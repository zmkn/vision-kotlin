package com.zmkn.audio.model

import com.zmkn.audio.enumeration.AudioChannels
import com.zmkn.audio.enumeration.AudioSampleRate
import com.zmkn.audio.enumeration.AudioSampleSizeInBits
import javax.sound.sampled.AudioFormat

data class AudioAttributes(
    val encoding: AudioFormat.Encoding = AudioFormat.Encoding.PCM_SIGNED,
    val channels: AudioChannels = AudioChannels.MONO,
    val sampleSizeInBits: Int = AudioSampleSizeInBits.B16.number,
    val sampleRate: Int = AudioSampleRate.R44100.number,
    val bigEndian: Boolean = false,
    val properties: Map<String, Any> = mapOf(),
)
