package com.zmkn.vision.audio.enumeration

enum class AudioSampleRate(
    val value: String,
    val number: Int,
) {
    R8000("R8000", 8000),
    R11025("R11025", 11025),
    R16000("R16000", 16000),
    R22050("R22050", 22050),
    R24000("R24000", 24000),
    R32000("R32000", 32000),
    R44100("R44100", 44100),
    R48000("R48000", 48000),
    R96000("R96000", 96000),
    R192000("R192000", 192000);

    override fun toString(): String {
        return value
    }

    companion object {
        fun fromValue(value: String): AudioSampleRate? {
            entries.forEach {
                if (value == it.value) {
                    return it
                }
            }
            return null
        }
    }
}
