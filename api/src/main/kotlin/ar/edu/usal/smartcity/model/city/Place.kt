package ar.edu.usal.smartcity.model.city

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "place", schema = "city")
class Place(
    @Id
    var id: String = "",

    var type: PlaceType = PlaceType.OTHER,

    var description: String? = null
)

enum class PlaceType {
    TRAFFIC_LIGHT,
    TOLL,
    PARKING,
    OTHER
}
