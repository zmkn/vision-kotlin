import com.zmkn.audio.enumeration.AudioDecoder
import com.zmkn.audio.model.EncodingOptions
import com.zmkn.audio.model.OutputOptions
import com.zmkn.audio.util.AudioUtils
import org.junit.jupiter.api.Disabled
import ws.schild.jave.Encoder
import java.io.File
import kotlin.test.Test

class AudioUtilsText {
    @Test
    @Disabled
    fun test() {
        val encoder = Encoder()
        encoder.audioDecoders.forEach {
//            println(it)
        }
        val qq = mutableListOf<AudioDecoder>()
        val s =
            "8svx_exp 8svx_fib aac aac_fixed aac_latm ac3 ac3_fixed acelp.kelvin adpcm_4xm adpcm_adx adpcm_afc adpcm_agm adpcm_aica adpcm_argo adpcm_ct adpcm_dtk adpcm_ea adpcm_ea_maxis_xa adpcm_ea_r1 adpcm_ea_r2 adpcm_ea_r3 adpcm_ea_xas g722 g726 g726le adpcm_ima_alp adpcm_ima_amv adpcm_ima_apc adpcm_ima_apm adpcm_ima_cunning adpcm_ima_dat4 adpcm_ima_dk3 adpcm_ima_dk4 adpcm_ima_ea_eacs adpcm_ima_ea_sead adpcm_ima_iss adpcm_ima_moflex adpcm_ima_mtf adpcm_ima_oki adpcm_ima_qt adpcm_ima_rad adpcm_ima_smjpeg adpcm_ima_ssi adpcm_ima_wav adpcm_ima_ws adpcm_ms adpcm_mtaf adpcm_psx adpcm_sbpro_2 adpcm_sbpro_3 adpcm_sbpro_4 adpcm_swf adpcm_thp adpcm_thp_le adpcm_vima adpcm_xa adpcm_yamaha adpcm_zork alac amrnb libopencore_amrnb amrwb libopencore_amrwb ape aptx aptx_hd atrac1 atrac3 atrac3al atrac3plus atrac3plusal atrac9 on2avc binkaudio_dct binkaudio_rdft bmv_audio comfortnoise cook derf_dpcm dolby_e dsd_lsbf dsd_lsbf_planar dsd_msbf dsd_msbf_planar dsicinaudio dss_sp dst dca dvaudio eac3 evrc fastaudio flac g723_1 g729 gremlin_dpcm gsm libgsm gsm_ms libgsm_ms hca hcom iac ilbc imc interplay_dpcm interplayacm mace3 mace6 metasound mlp mp1 mp1float mp2 mp2float mp3float mp3 mp3adufloat mp3adu mp3on4float mp3on4 als mpc7 mpc8 nellymoser opus libopus paf_audio pcm_alaw pcm_bluray pcm_dvd pcm_f16le pcm_f24le pcm_f32be pcm_f32le pcm_f64be pcm_f64le pcm_lxf pcm_mulaw pcm_s16be pcm_s16be_planar pcm_s16le pcm_s16le_planar pcm_s24be pcm_s24daud pcm_s24le pcm_s24le_planar pcm_s32be pcm_s32le pcm_s32le_planar pcm_s64be pcm_s64le pcm_s8 pcm_s8_planar pcm_sga pcm_u16be pcm_u16le pcm_u24be pcm_u24le pcm_u32be pcm_u32le pcm_u8 pcm_vidc qcelp qdm2 qdmc real_144 real_288 ralf roq_dpcm s302m sbc sdx2_dpcm shorten sipr siren smackaud sol_dpcm sonic libspeex tak truehd truespeech tta twinvq vmdaudio vorbis libvorbis wavesynth wavpack ws_snd1 wmalossless wmapro wmav1 wmav2 wmavoice xan_dpcm xma1 xma2"
        s.split(" ").apply {
            println(size)
        }.forEach {
            val format = AudioDecoder.fromValue(it)
            if (format != null) {
                qq.add(format)
            }
        }
        println(qq.size)
        val cc = mutableListOf<AudioDecoder>()
        AudioDecoder.entries.forEach {
            cc.add(it)
        }
        println(cc.size)
        qq.forEach {
            cc.remove(it)
        }
        println(cc)
    }

    @Test
    @Disabled
    fun testConvert() {
        println("testConvert---start")
        val inputFile1 = File("temp/1.mp3")
        val outputFile = File("temp/output.mp3")
        println(inputFile1.exists())
        AudioUtils.convert(
            inputFile = inputFile1,
            outputFile = outputFile,
            outputOptions = OutputOptions(),
            encodingOptions = EncodingOptions(),
        )
        println("testConvert---end")
    }

    @Test
    fun testConvert2() {
        println("testConvert---start")
        val inputFile1 = File("temp/1.mp3")
        val inputFile2 = File("temp/2.mp3")
        val outputFile = File("temp/output-all.mp3")
        println(inputFile1.exists())
        AudioUtils.convert(
            inputFiles = listOf(inputFile1, inputFile2),
            outputFile = outputFile,
            outputOptions = OutputOptions(),
            encodingOptions = EncodingOptions(),
        )
        println("testConvert---end")
    }
}
