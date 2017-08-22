package ar.edu.usal.smartcity.model.city

import ar.edu.usal.smartcity.model.common.Location
import ar.edu.usal.smartcity.model.common.Resource
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "traffic_violation", schema = "city")
class TrafficViolation(
    var creationTime: LocalDateTime = LocalDateTime.now(),
    @OneToOne
    var image: Resource?,
    @ManyToOne
    var location: Location = Location(),
    @ManyToOne
    var vehicle: Vehicle = Vehicle(),
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
)