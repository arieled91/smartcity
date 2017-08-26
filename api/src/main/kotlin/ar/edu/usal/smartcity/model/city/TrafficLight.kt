package ar.edu.usal.smartcity.model.city

import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "traffic_light", schema = "city")
data class TrafficLight (
    var status: TrafficLightStatus = TrafficLightStatus.WARNING,

    var updateTime: LocalDateTime = LocalDateTime.MIN,

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

//    @Id
//    @GeneratedValue(generator = "system-uuid")
//    @GenericGenerator(name = "system-uuid", strategy = "uuid")
//    var uuid: UUID = UUID(0L,0L)
){
    fun nextStatus(){
        status = status.next();
    }

    @PreUpdate
    @PrePersist
    private fun updateUpdateTime() {
        updateTime = LocalDateTime.now()
    }
}

enum class TrafficLightStatus(val secondsLong: Int){
    GO(10){
        override fun next() = CHANGE_STOP
    },
    CHANGE_STOP(3) {
        override fun next() = STOP
    },
    STOP(10) {
        override fun next() = CHANGE_GO
    },
    CHANGE_GO(3) {
        override fun next() = GO
    },
    WARNING(0) {
        override fun next() = GO
    };

    abstract fun next(): TrafficLightStatus
}