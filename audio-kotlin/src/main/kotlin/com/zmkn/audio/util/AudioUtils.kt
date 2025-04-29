package com.zmkn.audio.util

import com.zmkn.audio.extension.toAudioAttributes
import com.zmkn.audio.extension.toEncodingAttributes
import com.zmkn.audio.model.EncodingOptions
import com.zmkn.audio.model.OutputOptions
import ws.schild.jave.Encoder
import ws.schild.jave.MultimediaObject
import ws.schild.jave.encode.VideoAttributes
import ws.schild.jave.filters.FilterChain
import ws.schild.jave.filters.FilterGraph
import ws.schild.jave.filters.MediaConcatFilter
import ws.schild.jave.progress.EncoderProgressListener
import java.io.File

object AudioUtils {
    fun convert(
        inputFile: File,
        outputFile: File,
        outputOptions: OutputOptions = OutputOptions(),
        encodingOptions: EncodingOptions = EncodingOptions(),
        listener: EncoderProgressListener? = null,
    ) {
        val encodingAttributes = encodingOptions.toEncodingAttributes(outputOptions.toAudioAttributes())
        Encoder().encode(MultimediaObject(inputFile), outputFile, encodingAttributes, listener)
    }

    fun convert(
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
}
