package ar.edu.usal.smartcity.model.city

import ar.edu.usal.common.EnumMapException
import ar.edu.usal.smartcity.model.common.Location
import ar.edu.usal.smartcity.model.common.Resource
import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table(name = "traffic_violation", schema = "city")
class TrafficViolation(
    @ManyToOne(cascade = arrayOf(CascadeType.ALL))
    var location: Location = Location(),

    @Convert(converter = ViolationTypeConverter::class)
    var type: ViolationType = ViolationType.SPEED,

    var creationTime: LocalDateTime = LocalDateTime.now(),

    @OneToOne
    var image: Resource?=null,

    @ManyToOne
    var vehicle: Vehicle? = null,

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
)

enum class ViolationType(var key: Int) {
    SPEED(1),
    RED_LIGHT(2)
}


@Converter
class ViolationTypeConverter : AttributeConverter<ViolationType, Int> {

    override fun convertToDatabaseColumn(attribute: ViolationType): Int {
        return attribute.key
    }

    override fun convertToEntityAttribute(dbData: Int): ViolationType {
        return ViolationType.values().associateBy(ViolationType::key)[dbData] ?: throw EnumMapException(ViolationType::class)
    }
}
