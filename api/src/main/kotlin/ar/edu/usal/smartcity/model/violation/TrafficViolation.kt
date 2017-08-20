package ar.edu.usal.smartcity.model.violation

import ar.edu.usal.smartcity.model.city.Vehicle
import ar.edu.usal.smartcity.model.common.Location
import ar.edu.usal.smartcity.model.common.Resource
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "traffic_violation", schema = "violation")
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