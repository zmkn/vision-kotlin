package com.zmkn.audio.extension

import com.zmkn.audio.model.AudioAttributes
import javax.sound.sampled.AudioFormat
import javax.sound.sampled.AudioSystem

fun AudioAttributes.toAudioFormat(): AudioFormat {
    val channelsNumber = channels.number
    val frameSize = if (channelsNumber == AudioSystem.NOT_SPECIFIED || sampleSizeInBits == AudioSystem.NOT_SPECIFIED) {
        AudioSystem.NOT_SPECIFIED
    } else {
        ((sampleSizeInBits + 7) / 8) * channelsNumber
    }
    return AudioFormat(
        encoding,
        sampleRate.toFloat(),
        sampleSizeInBits,
        channelsNumber,
        frameSize,
        sampleRate.toFloat(),
        bigEndian,
        properties,
    )
}
