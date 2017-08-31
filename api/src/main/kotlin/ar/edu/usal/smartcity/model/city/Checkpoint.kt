package ar.edu.usal.smartcity.model.city

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "checkpoint", schema = "city")
class Checkpoint (
    vehicle: Vehicle = Vehicle(),
    var creationTime: LocalDateTime = LocalDateTime.now(),
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
)