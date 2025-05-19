package com.zmkn.vision.audio.model

import java.io.File

data class InputAudioFileAttributes(
    val file: File,
    val audioAttributes: AudioAttributes = AudioAttributes(),
)
