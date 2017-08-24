package ar.edu.usal.smartcity.persistance

import ar.edu.usal.common.Dev
import ar.edu.usal.smartcity.model.city.*
import ar.edu.usal.smartcity.model.common.Location
import ar.edu.usal.smartcity.model.common.Resource
import ar.edu.usal.smartcity.repository.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.time.LocalDateTime


@Dev
@Component
class DatabaseLoader : CommandLineRunner {

    @Autowired lateinit var checkpointRepo: CheckpointRepository
    @Autowired lateinit var tagRepo: TagRepository
    @Autowired lateinit var resourceRepo: ResourceRepository
    @Autowired lateinit var trafficViolRepo: TrafficViolationRepository
    @Autowired lateinit var trafficLightRepo: TrafficLightRepository

    override fun run(vararg args: String?) {

        if (tagRepo.findAll().count() == 0) {

            val testImage = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAARElEQVR42u3PMREAAAgEoLd/YEfN4OpBA2qSzgMlIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiInKxnANiP8ezyscAAAAASUVORK5CYII="

            val resource = Resource().buildFromBase64(testImage)

            resourceRepo.save(resource)

            trafficViolRepo.save(TrafficViolation(Location("test loc",54544,3234), ViolationType.SPEED, LocalDateTime.now(), resource))

            val testTagNumber = "123456"

            val location = Location("lugar de prueba")

            val testTag: Tag = tagRepo.save(Tag(testTagNumber, TagType.OTHER, location))

            checkpointRepo.save(Checkpoint("test-device", testTag))
            checkpointRepo.save(Checkpoint("test-device", testTag))

            trafficLightRepo.save(TrafficLight())
        }

    }
}
