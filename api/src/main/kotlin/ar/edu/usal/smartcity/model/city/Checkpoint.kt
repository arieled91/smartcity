package ar.edu.usal.smartcity.model.city

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "checkpoint", schema = "city")
class Checkpoint (
    @ManyToOne
    var vehicle: Vehicle = Vehicle(),

    @ManyToOne
    var place: Place = Place(),

    var creationTime: LocalDateTime = LocalDateTime.now(),

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
)