package com.zmkn.vision.audio.model

import com.zmkn.vision.audio.enumeration.EncodingFormat

data class EncodingOptions(
    val outputFormat: EncodingFormat = EncodingFormat.MP3,
    val loop: Boolean = false,
    val copyMetaData: Boolean = true,
    val offset: Float? = null,
    val duration: Float? = null,
    val filterThreads: Int? = null,
    val safe: Int? = null,
    val encodingThreads: Int? = null,
    val decodingThreads: Int? = null,
    val extraContext: Map<String, String>? = null,
)
