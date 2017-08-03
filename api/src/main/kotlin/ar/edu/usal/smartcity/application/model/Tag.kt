package ar.edu.usal.smartcity.application.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "tag"/*, schema = "smartcity"*/)
data class Tag(
    var deviceId: String = "",
    var tagId: String = "",
    var creationTime : LocalDateTime = LocalDateTime.now(),

    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    var id : Long = 0
)