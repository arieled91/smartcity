package ar.edu.usal.smartcity.task

import ar.edu.usal.smartcity.model.city.TrafficLight
import ar.edu.usal.smartcity.model.city.TrafficLightStatus
import ar.edu.usal.smartcity.repository.TrafficLightRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.LocalDateTime


@Component
class TrafficLightTasks {

    @Autowired lateinit var trafficLightRepo: TrafficLightRepository

    @Scheduled(fixedRate = 10000)
    fun longStatusUpdater() {
        updateSynchronized()
    }

    @Scheduled(fixedRate = 3000)
    fun transitionStatusUpdater() {
        updateByStatus(TrafficLightStatus.CHANGE_STOP)
        updateByStatus(TrafficLightStatus.CHANGE_GO)
    }

    fun updateByStatus(status: TrafficLightStatus) {
        val updateTime = LocalDateTime.now().minusSeconds(status.secondsLong.toLong())
        val trafficLights = trafficLightRepo.findByStatusAndUpdateTimeLessThan(status, updateTime)

        trafficLights.forEach { trafficLight ->
            trafficLight.nextStatus()
            trafficLightRepo.save(trafficLight)
        }
    }

    fun updateSynchronized(){
        trafficLightRepo.findWithoutIntersection().forEach({
            trafficLight ->
                trafficLight.nextStatus()
                findIntersection(trafficLight)?.nextStatus()
        })
    }


    fun findIntersection(trafficLight: TrafficLight) : TrafficLight?{
        return trafficLightRepo.findByPositionAndIntersection(trafficLight.intersection, trafficLight.position)
    }
}