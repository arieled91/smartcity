package ar.edu.usal.smartcity.model.city

import ar.edu.usal.smartcity.model.city.Party
import javax.persistence.*

@Entity
@Table(name = "vehicle", schema = "city")
class Vehicle(
    @ManyToOne
    var owner: Party = Party(),
    var licensePlate: String = "",
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
)