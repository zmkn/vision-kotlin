package com.zmkn.vision.audio.filter

import ws.schild.jave.filters.Filter

class VolumeFilter(private val volumeMultiple: Double) : Filter("volume") {
    override fun getExpression(): String = "volume=$volumeMultiple"
}
