package com.zmkn.audio.model

import com.zmkn.audio.enumeration.AudioBitrate
import com.zmkn.audio.enumeration.AudioChannels
import com.zmkn.audio.enumeration.AudioEncoder
import com.zmkn.audio.enumeration.AudioSampleRate

data class OutputOptions(
    val codec: AudioEncoder = AudioEncoder.LIBMP3LAME,
    val channels: AudioChannels = AudioChannels.MONO,
    val sampleRate: Int = AudioSampleRate.R44100.number,
    val bitrate: Int = AudioBitrate.B128000.number,
    val volumeMultiple: Double = 1.0,
    val quality: Int? = null,
)
