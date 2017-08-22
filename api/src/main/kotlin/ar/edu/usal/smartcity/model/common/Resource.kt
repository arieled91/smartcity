package ar.edu.usal.smartcity.model.common

import ar.edu.usal.common.Base64Helper
import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.http.MediaType
import javax.persistence.*

@Entity
@Table(name = "resource", schema = "common")
data class Resource(
    @JsonIgnore @Lob var bytes: ByteArray = byteArrayOf()
){
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
    @JsonIgnore
    var mediaType: MediaType = MediaType.APPLICATION_OCTET_STREAM

    fun buildFromBase64(rawBase64: String): Resource {
        val base64Helper = Base64Helper(rawBase64)
        mediaType=base64Helper.mediaType
        bytes=base64Helper.getDataBytes()
        return this
    }

    fun getBase64(): String{
        return Base64Helper(mediaType, bytes).getDataWithHeader()
    }

}