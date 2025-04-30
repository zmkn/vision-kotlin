package com.zmkn.audio.enumeration

enum class AudioSampleSizeInBits(
    val value: String,
    val number: Int,
) {
    B8("B8", 8),
    B16("B16", 16),
    B24("B24", 24),
    B32("B32", 32),
    B64("B64", 64);

    override fun toString(): String {
        return value
    }

    companion object {
        fun fromValue(value: String): AudioSampleSizeInBits? {
            entries.forEach {
                if (value == it.value) {
                    return it
                }
            }
            return null
        }
    }
}
