package ar.edu.usal.common

import org.springframework.http.MediaType
import java.util.*
import javax.xml.bind.DatatypeConverter

class Base64Helper(
    var mediaType: MediaType = MediaType.APPLICATION_OCTET_STREAM,
    var data: String = ""
)
{
    constructor(rawBase64: String) : this() {
        if (hasHeader(rawBase64)) {
            val base64 = splitBase64Data(rawBase64)
            mediaType = MediaType.valueOf(base64[0])
            data = base64[1]
        } else data = rawBase64
    }

    constructor(mediaType: MediaType, bytes: ByteArray) : this() {
        data = DatatypeConverter.printBase64Binary(bytes)
        this.mediaType = mediaType
    }

    fun getDataWithHeader(): String {
        return "data:$mediaType;base64,$data"
    }

    fun getDataBytes(): ByteArray {
        return decode(data)
    }

    companion object {
        fun decode(base64: String): ByteArray {
            return Base64.getDecoder().decode(base64.toByteArray())
        }
    }

    private fun splitBase64Data(base64: String): List<String> {
        // index 0: MediaType, intex 1: data
        return base64.substring(5, base64.length).split(";base64,")
    }

    private fun hasHeader(base64: String): Boolean {
        return base64.startsWith("data:")
    }
}