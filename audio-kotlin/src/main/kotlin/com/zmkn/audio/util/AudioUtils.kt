package com.zmkn.audio.util

import com.zmkn.audio.enumeration.AudioBitrate
import com.zmkn.audio.enumeration.AudioChannels
import com.zmkn.audio.enumeration.AudioFormat
import com.zmkn.audio.enumeration.AudioSampleRate
import org.bytedeco.ffmpeg.global.avcodec
import org.bytedeco.ffmpeg.global.avutil.AV_SAMPLE_FMT_S16
import org.bytedeco.javacv.FFmpegFrameGrabber
import org.bytedeco.javacv.FFmpegFrameRecorder
import java.io.File

object AudioUtils {
    fun mergeAudioFiles(
        inputFiles: List<File>,
        outputFilePath: String,
        outputFormat: AudioFormat,
        outputChannels: AudioChannels = AudioChannels.MONO,
        outputSampleRate: Int = AudioSampleRate.R44100.number,
        outputBitrate: Int = AudioBitrate.B128000.number,
    ) {
        val recorder = FFmpegFrameRecorder(outputFilePath, outputChannels.number).apply {
            format = outputFormat.value
            sampleRate = outputSampleRate
            audioBitrate = outputBitrate
            setAudioOption("crf", "23") // 控制压缩质量
            when (outputFormat) {
                AudioFormat.MP3 -> setAudioCodec(avcodec.AV_CODEC_ID_MP3)
                AudioFormat.WAV -> setAudioCodec(avcodec.AV_CODEC_ID_PCM_S16LE)
                else -> throw IllegalArgumentException("Unsupported format: $outputFormat")
            }
            start()
        }

        try {
            inputFiles.forEach { file ->
                FFmpegFrameGrabber(file).apply {
                    // 处理 PCM 文件需要手动指定参数
                    if (file.extension.equals("pcm", true)) {
                        setSampleFormat(AV_SAMPLE_FMT_S16) // 根据实际 PCM 格式调整
                        setSampleRate(outputSampleRate)
                        setAudioChannels(outputChannels)
                    }
                    start()
                }.use { grabber ->
                    // 动态获取输入参数（仅作参考，实际可能需要强制转码）
                    val inputSampleRate = grabber.sampleRate
                    val inputChannels = grabber.audioChannels

                    var frame = grabber.grab()
                    while (frame != null && frame.samples != null) {
                        // 强制转码到目标参数（采样率、声道数）
                        if (inputSampleRate != outputSampleRate || inputChannels != outputChannels) {
                            frame = convertFrame(frame, inputSampleRate, inputChannels, outputSampleRate, outputChannels)
                        }
                        recorder.record(frame)
                        frame = grabber.grab() // 流式读取下一帧
                    }
                }
            }
        } finally {
            recorder.close()
        }
    }
}
