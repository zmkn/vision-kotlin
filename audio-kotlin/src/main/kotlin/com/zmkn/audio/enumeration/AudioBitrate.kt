package com.zmkn.audio.enumeration

enum class AudioBitrate(
    val value: String,
    val number: Int,
) {
    B24000("B24000", 24000),
    B32000("B32000", 32000),
    B48000("B48000", 48000),
    B64000("B64000", 64000),
    B80000("B80000", 80000),
    B96000("B96000", 96000),
    B128000("B128000", 128000),
    B160000("B160000", 160000),
    B192000("B192000", 192000),
    B256000("B256000", 256000),
    B320000("B320000", 320000);

    override fun toString(): String {
        return value
    }

    companion object {
        fun fromValue(value: String): AudioBitrate? {
            entries.forEach {
                if (value == it.value) {
                    return it
                }
            }
            return null
        }
    }
}
