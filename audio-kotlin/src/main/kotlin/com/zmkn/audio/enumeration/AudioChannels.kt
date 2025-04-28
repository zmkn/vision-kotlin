package com.zmkn.audio.enumeration

enum class AudioChannels(
    val value: String,
    val number: Int,
) {
    MONO("MONO", 1),
    STEREO("STEREO", 2);

    override fun toString(): String {
        return value
    }

    companion object {
        fun fromValue(value: String): AudioChannels? {
            entries.forEach {
                if (value == it.value) {
                    return it
                }
            }
            return null
        }
    }
}
