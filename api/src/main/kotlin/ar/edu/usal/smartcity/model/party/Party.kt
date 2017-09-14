package ar.edu.usal.smartcity.model.party

import javax.persistence.*

@Entity
@Table(name = "party", schema = "party")
class Party(
    var name: String = "",

    var lastName: String? = "",

    var legalId: String = "0",

    @OneToOne
    var account: Account? = null,

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
)