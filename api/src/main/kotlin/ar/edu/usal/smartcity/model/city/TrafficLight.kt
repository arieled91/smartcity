package ar.edu.usal.smartcity.model.city

import javax.persistence.*

@Entity
@Table(name = "traffic_light", schema = "city")
class TrafficLight (
    var status: TrafficLightStatus = TrafficLightStatus.WARNING,
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

//    @Id
//    @GeneratedValue(generator = "system-uuid")
//    @GenericGenerator(name = "system-uuid", strategy = "uuid")
//    var uuid: UUID = UUID(0L,0L)
)

enum class TrafficLightStatus{
    GO, CHANGE_GO, CHANGE_STOP, STOP, WARNING
}