package ar.edu.usal.smartcity.model.city

import javax.persistence.*

@Entity
@Table(name = "street", schema = "city")
class Street (
    var name: String = "",

    var direction: CardinalDirection = CardinalDirection.N,

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
)

enum class CardinalDirection{
    N, S, E, O
}