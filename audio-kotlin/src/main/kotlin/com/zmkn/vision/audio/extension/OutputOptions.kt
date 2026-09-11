package com.zmkn.vision.audio.extension

import com.zmkn.vision.audio.model.OutputOptions
import ws.schild.jave.encode.AudioAttributes

fun OutputOptions.toAudioAttributes(): AudioAttributes = AudioAttributes()
    .setCodec(codec.value)
    .setChannels(channels.number)
    .setSamplingRate(sampleRate)
    .setBitRate(bitrate)
    .also {
        if (quality != null) {
            it.setQuality(quality)
        }
    }
