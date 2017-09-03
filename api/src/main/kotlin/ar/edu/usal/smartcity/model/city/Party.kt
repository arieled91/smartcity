package ar.edu.usal.smartcity.model.city

import javax.persistence.*

@Entity
@Table(name = "party", schema = "city")
class Party(
    var name: String = "",

    var lastName: String? = "",

    var legalId: String = "0",

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
)