package ar.edu.usal.smartcity.model.city

import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "traffic_light", schema = "city")
data class TrafficLight(
    @Id
    var id: String = UUID.randomUUID().toString(),

    @Enumerated(EnumType.STRING)
    var status: TrafficLightStatus = TrafficLightStatus.WARNING,

    @ManyToOne
    var position: Street = Street(),

    @ManyToOne
    var intersection: Street = Street(),

    @JsonIgnore
    var updateTime: LocalDateTime = LocalDateTime.MIN

//    @Id
//    @GeneratedValue(generator = "system-uuid")
//    @GenericGenerator(name = "system-uuid", strategy = "uuid")
//    var uuid: UUID = UUID(0L,0L)
) {
    fun nextStatus() {
        status = status.next();
    }

    @PreUpdate @PrePersist
    private fun updateUpdateTime() {
        updateTime = LocalDateTime.now()
    }
}

enum class TrafficLightStatus(val secondsLong: Int) {
    GO(10) {
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