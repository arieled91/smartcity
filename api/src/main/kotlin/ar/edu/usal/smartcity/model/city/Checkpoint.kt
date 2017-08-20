package ar.edu.usal.smartcity.model.city

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "checkpoint", schema = "city")
data class Checkpoint(
    var vehicleId: String = "",
    @ManyToOne
    @JoinColumn(name = "tag_id")
    var tag: Tag = Tag(),
    var dateTime: LocalDateTime = LocalDateTime.now(),
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
)