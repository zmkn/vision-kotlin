package com.zmkn.audio.enumeration

enum class AudioEncoder(val value: String) {
    AAC("aac"),
    AC3("ac3"),
    AC3_FIXED("ac3_fixed"),
    ADPCM_ADX("adpcm_adx"),
    ADPCM_ARGO("adpcm_argo"),
    G722("g722"),
    G726("g726"),
    G726LE("g726le"),
    ADPCM_IMA_ALP("adpcm_ima_alp"),
    ADPCM_IMA_AMV("adpcm_ima_amv"),
    ADPCM_IMA_APM("adpcm_ima_apm"),
    ADPCM_IMA_QT("adpcm_ima_qt"),
    ADPCM_IMA_SSI("adpcm_ima_ssi"),
    ADPCM_IMA_WAV("adpcm_ima_wav"),
    ADPCM_MS("adpcm_ms"),
    ADPCM_SWF("adpcm_swf"),
    ADPCM_YAMAHA("adpcm_yamaha"),
    ALAC("alac"),
    LIBOPENCORE_AMRNB("libopencore_amrnb"),
    LIBVO_AMRWBENC("libvo_amrwbenc"),
    APTX("aptx"),
    APTX_HD("aptx_hd"),
    COMFORTNOISE("comfortnoise"),
    DCA("dca"),
    EAC3("eac3"),
    FLAC("flac"),
    G723_1("g723_1"),
    LIBGSM("libgsm"),
    LIBGSM_MS("libgsm_ms"),
    MLP("mlp"),
    MP2("mp2"),
    MP2FIXED("mp2fixed"),
    LIBMP3LAME("libmp3lame"),
    NELLYMOSER("nellymoser"),
    OPUS("opus"),
    LIBOPUS("libopus"),
    PCM_ALAW("pcm_alaw"),
    PCM_DVD("pcm_dvd"),
    PCM_F32BE("pcm_f32be"),
    PCM_F32LE("pcm_f32le"),
    PCM_F64BE("pcm_f64be"),
    PCM_F64LE("pcm_f64le"),
    PCM_MULAW("pcm_mulaw"),
    PCM_S16BE("pcm_s16be"),
    PCM_S16BE_PLANAR("pcm_s16be_planar"),
    PCM_S16LE("pcm_s16le"),
    PCM_S16LE_PLANAR("pcm_s16le_planar"),
    PCM_S24BE("pcm_s24be"),
    PCM_S24DAUD("pcm_s24daud"),
    PCM_S24LE("pcm_s24le"),
    PCM_S24LE_PLANAR("pcm_s24le_planar"),
    PCM_S32BE("pcm_s32be"),
    PCM_S32LE("pcm_s32le"),
    PCM_S32LE_PLANAR("pcm_s32le_planar"),
    PCM_S64BE("pcm_s64be"),
    PCM_S64LE("pcm_s64le"),
    PCM_S8("pcm_s8"),
    PCM_S8_PLANAR("pcm_s8_planar"),
    PCM_U16BE("pcm_u16be"),
    PCM_U16LE("pcm_u16le"),
    PCM_U24BE("pcm_u24be"),
    PCM_U24LE("pcm_u24le"),
    PCM_U32BE("pcm_u32be"),
    PCM_U32LE("pcm_u32le"),
    PCM_U8("pcm_u8"),
    PCM_VIDC("pcm_vidc"),
    REAL_144("real_144"),
    ROQ_DPCM("roq_dpcm"),
    S302M("s302m"),
    SBC("sbc"),
    SONIC("sonic"),
    SONICLS("sonicls"),
    LIBSPEEX("libspeex"),
    TRUEHD("truehd"),
    TTA("tta"),
    VORBIS("vorbis"),
    LIBVORBIS("libvorbis"),
    WAVPACK("wavpack"),
    WMAV1("wmav1"),
    WMAV2("wmav2");

    override fun toString(): String {
        return value
    }

    companion object {
        fun fromValue(value: String): AudioEncoder? {
            entries.forEach {
                if (value == it.value) {
                    return it
                }
            }
            return null
        }
    }
}
