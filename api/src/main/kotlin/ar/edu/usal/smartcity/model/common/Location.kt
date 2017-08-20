package ar.edu.usal.smartcity.model.common

import javax.persistence.*

@Entity
@Table(name = "location", schema = "common")
class Location(
    var description: String = "",
    var lat: Int = 0,
    var lon: Int = 0,
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
)