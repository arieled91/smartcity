package ar.edu.usal.smartcity.model.city

import ar.edu.usal.smartcity.model.common.Location
import javax.persistence.*

@Entity
@Table(name = "tag", schema = "city")
class Tag(
    @Column(unique = true)
    var code: String = "",
    var type: TagType = TagType.OTHER,
    @OneToOne(cascade = arrayOf(CascadeType.ALL))
    var location: Location = Location(),
    var description: String? = null,


    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
)

enum class TagType {
    TRAFFIC_LIGHT,
    TOLL,
    PARKING,
    OTHER
}
