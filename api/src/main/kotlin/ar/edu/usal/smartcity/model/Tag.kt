package ar.edu.usal.smartcity.model

import javax.persistence.*

@Entity
@Table(name = "tag"/*, schema = "smartcity"*/)
@Embeddable
class Tag (
        @Column(unique=true)
        var code : String = "",
        var type : TagType = TagType.OTHER,
        var location : String = "",
        var description : String? = null,


        @Id @GeneratedValue(strategy= GenerationType.AUTO)
        var id : Long = 0
)

enum class TagType {
    TRAFFIC_LIGHT,
    TOLL,
    PARKING,
    OTHER
}
