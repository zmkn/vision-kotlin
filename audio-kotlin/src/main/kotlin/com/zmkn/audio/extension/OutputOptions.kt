package com.zmkn.audio.extension

import com.zmkn.audio.model.OutputOptions
import ws.schild.jave.encode.AudioAttributes
import kotlin.math.roundToInt

fun OutputOptions.toAudioAttributes(): AudioAttributes = AudioAttributes()
    .setCodec(codec.value)
    .setChannels(channels.number)
    .setSamplingRate(sampleRate)
    .setBitRate(bitrate)
    .setVolume((volumeMultiple * 256).roundToInt())
    .also {
        if (quality != null) {
            it.setQuality(quality)
        }
    }
