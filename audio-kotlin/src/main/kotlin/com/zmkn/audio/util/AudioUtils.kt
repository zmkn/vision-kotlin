package com.zmkn.audio.util

import com.zmkn.audio.extension.toAudioAttributes
import com.zmkn.audio.extension.toAudioFormat
import com.zmkn.audio.extension.toEncodingAttributes
import com.zmkn.audio.model.AudioAttributes
import com.zmkn.audio.model.EncodingOptions
import com.zmkn.audio.model.InputAudioFileAttributes
import com.zmkn.audio.model.OutputOptions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ws.schild.jave.Encoder
import ws.schild.jave.MultimediaObject
import ws.schild.jave.encode.VideoAttributes
import ws.schild.jave.filters.FilterChain
import ws.schild.jave.filters.FilterGraph
import ws.schild.jave.filters.MediaConcatFilter
import ws.schild.jave.progress.EncoderProgressListener
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import javax.sound.sampled.AudioInputStream
import javax.sound.sampled.AudioSystem

object AudioUtils {
    fun convertSync(
        inputFile: File,
        outputFile: File,
        outputOptions: OutputOptions = OutputOptions(),
        encodingOptions: EncodingOptions = EncodingOptions(),
        listener: EncoderProgressListener? = null,
    ) {
        val encodingAttributes = encodingOptions.toEncodingAttributes(outputOptions.toAudioAttributes())
        Encoder().encode(MultimediaObject(inputFile), outputFile, encodingAttributes, listener)
    }

    fun convertSync(
        inputFiles: List<File>,
        outputFile: File,
        outputOptions: OutputOptions = OutputOptions(),
        encodingOptions: EncodingOptions = EncodingOptions(),
        listener: EncoderProgressListener? = null,
    ) {
        val multimediaObjects = inputFiles.map {
            MultimediaObject(it)
        }
        val filterChain = FilterChain().addFilter(MediaConcatFilter(multimediaObjects.size, false, true))
        val filterGraph = FilterGraph().addChain(filterChain)
        val videoAttributes = VideoAttributes().setComplexFiltergraph(filterGraph)
        val encodingAttributes = encodingOptions.toEncodingAttributes(
            audioAttributes = outputOptions.toAudioAttributes(),
            videoAttributes = videoAttributes,
        )
        Encoder().encode(multimediaObjects, outputFile, encodingAttributes, listener)
    }

    fun convertPcmSync(
        inputFile: File,
        outputFile: File,
        inputAudioAttributes: AudioAttributes = AudioAttributes(),
        outputAudioAttributes: AudioAttributes = AudioAttributes(),
    ) {
        FileOutputStream(outputFile).use { fileOutputStream ->
            val audioInputStream = AudioInputStream(FileInputStream(inputFile), inputAudioAttributes.toAudioFormat(), inputFile.length())
            val convertedStream = AudioSystem.getAudioInputStream(outputAudioAttributes.toAudioFormat(), audioInputStream)
            convertedStream.copyTo(fileOutputStream)
            convertedStream.close()
        }
    }

    fun convertPcmSync(
        inputAudioFileAttributes: List<InputAudioFileAttributes>,
        outputFile: File,
        outputAudioAttributes: AudioAttributes = AudioAttributes(),
    ) {
        FileOutputStream(outputFile).use { fileOutputStream ->
            inputAudioFileAttributes.forEach { inputAudioFileAttribute ->
                val audioInputStream = AudioInputStream(FileInputStream(inputAudioFileAttribute.file), inputAudioFileAttribute.audioAttributes.toAudioFormat(), inputAudioFileAttribute.file.length())
                val convertedStream = AudioSystem.getAudioInputStream(outputAudioAttributes.toAudioFormat(), audioInputStream)
                convertedStream.copyTo(fileOutputStream)
                convertedStream.close()
            }
        }
    }

    fun connectPcmSync(
        inputFiles: List<File>,
        outputFile: File,
    ) {
        FileOutputStream(outputFile).use { fileOutputStream ->
            inputFiles.forEach { inputFile ->
                val fileInputStream = FileInputStream(inputFile)
                fileInputStream.copyTo(fileOutputStream)
                fileInputStream.close()
            }
        }
    }

    suspend fun convert(
        inputFile: File,
        outputFile: File,
        outputOptions: OutputOptions = OutputOptions(),
        encodingOptions: EncodingOptions = EncodingOptions(),
        listener: EncoderProgressListener? = null,
    ) = withContext(Dispatchers.IO) {
        convertSync(
            inputFile = inputFile,
            outputFile = outputFile,
            outputOptions = outputOptions,
            encodingOptions = encodingOptions,
            listener = listener,
        )
    }

    suspend fun convert(
        inputFiles: List<File>,
        outputFile: File,
        outputOptions: OutputOptions = OutputOptions(),
        encodingOptions: EncodingOptions = EncodingOptions(),
        listener: EncoderProgressListener? = null,
    ) = withContext(Dispatchers.IO) {
        convertSync(
            inputFiles = inputFiles,
            outputFile = outputFile,
            outputOptions = outputOptions,
            encodingOptions = encodingOptions,
            listener = listener,
        )
    }

    suspend fun convertPcm(
        inputFile: File,
        outputFile: File,
        inputAudioAttributes: AudioAttributes = AudioAttributes(),
        outputAudioAttributes: AudioAttributes = AudioAttributes(),
    ) = withContext(Dispatchers.IO) {
        convertPcmSync(
            inputFile = inputFile,
            outputFile = outputFile,
            inputAudioAttributes = inputAudioAttributes,
            outputAudioAttributes = outputAudioAttributes,
        )
    }

    suspend fun convertPcm(
        inputAudioFileAttributes: List<InputAudioFileAttributes>,
        outputFile: File,
        outputAudioAttributes: AudioAttributes = AudioAttributes(),
    ) = withContext(Dispatchers.IO) {
        convertPcmSync(
            inputAudioFileAttributes = inputAudioFileAttributes,
            outputFile = outputFile,
            outputAudioAttributes = outputAudioAttributes,
        )
    }

    suspend fun connectPcm(
        inputFiles: List<File>,
        outputFile: File,
    ) = withContext(Dispatchers.IO) {
        connectPcmSync(
            inputFiles = inputFiles,
            outputFile = outputFile,
        )
    }
}
