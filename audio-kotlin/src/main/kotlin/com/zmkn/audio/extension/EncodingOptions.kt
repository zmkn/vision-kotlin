package com.zmkn.audio.extension

import com.zmkn.audio.model.EncodingOptions
import ws.schild.jave.encode.AudioAttributes
import ws.schild.jave.encode.EncodingAttributes
import ws.schild.jave.encode.VideoAttributes

fun EncodingOptions.toEncodingAttributes(
    audioAttributes: AudioAttributes? = null,
    videoAttributes: VideoAttributes? = null,
): EncodingAttributes = EncodingAttributes()
    .setOutputFormat(outputFormat.value)
    .setLoop(loop)
    .setMapMetaData(copyMetaData)
    .also {
        if (audioAttributes != null) {
            it.setAudioAttributes(audioAttributes)
        }
        if (videoAttributes != null) {
            it.setVideoAttributes(videoAttributes)
        }
        if (offset != null) {
            it.setOffset(offset)
        }
        if (duration != null) {
            it.setDuration(duration)
        }
        if (safe != null) {
            it.setSafe(safe)
        }
        if (filterThreads != null) {
            it.setFilterThreads(filterThreads)
        }
        if (encodingThreads != null) {
            it.setEncodingThreads(encodingThreads)
        }
        if (decodingThreads != null) {
            it.setDecodingThreads(decodingThreads)
        }
        if (extraContext != null) {
            it.setExtraContext(extraContext)
        }
    }
