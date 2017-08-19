package ar.edu.usal.smartcity.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "checkpoint"/*, schema = "smartcity"*/)
data class Checkpoint(
    var deviceId: String = "",
    @ManyToOne
    @JoinColumn(name="tag_id")
    var tag: Tag = Tag(),
    var creationTime : LocalDateTime = LocalDateTime.now(),
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    var id : Long = 0
)