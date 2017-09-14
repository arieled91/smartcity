package ar.edu.usal.smartcity.model.city

import javax.persistence.*

@Entity
@Table(name = "place", schema = "city")
class Place(
    @Column(unique=true)
    var name: String = "",

    @Enumerated(EnumType.STRING)
    var type: PlaceType = PlaceType.OTHER,

    var description: String? = null,

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
)

enum class PlaceType {
    OTHER,
    TRAFFIC_LIGHT,
    TOLL,
    PARKING
}
