package com.zmkn.audio.model

import java.io.File

data class InputAudioFileAttributes(
    val file: File,
    val audioAttributes: AudioAttributes = AudioAttributes(),
)
