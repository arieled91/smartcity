package ar.edu.usal.smartcity.model.city

import ar.edu.usal.smartcity.model.party.Party
import javax.persistence.*

@Entity
@Table(name = "vehicle", schema = "city")
class Vehicle(
        @ManyToOne
    var owner: Party = Party(),

        var tagId: String = String(),

        @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
)