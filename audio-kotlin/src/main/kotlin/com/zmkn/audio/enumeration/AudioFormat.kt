package com.zmkn.audio.enumeration

enum class AudioFormat(val value: String) {
    MP3("mp3"),
    AAC("aac"),
    WAV("wav"),
    AIFF("aiff"),
    ALAC("alac");

    override fun toString(): String {
        return value
    }

    companion object {
        fun fromValue(value: String): AudioFormat? {
            entries.forEach {
                if (value == it.value) {
                    return it
                }
            }
            return null
        }
    }
}
