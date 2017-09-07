package ar.edu.usal.smartcity.repository

import ar.edu.usal.common.Dev
import ar.edu.usal.smartcity.model.city.*
import ar.edu.usal.smartcity.model.common.Location
import ar.edu.usal.smartcity.model.common.Resource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.time.LocalDateTime


@Dev
@Component
class DatabaseLoader : CommandLineRunner {

    @Autowired lateinit var checkpointRepo: CheckpointRepository
    @Autowired lateinit var resourceRepo: ResourceRepository
    @Autowired lateinit var trafficViolRepo: TrafficViolationRepository
    @Autowired lateinit var trafficLightRepo: TrafficLightRepository
    @Autowired lateinit var vehicleRepo: VehicleRepository
    @Autowired lateinit var partyRepo: PartyRepository
    @Autowired lateinit var placeRepo: PlaceRepository
    @Autowired lateinit var streetRepo: StreetRepository

    override fun run(vararg args: String?) {

        if (checkpointRepo.findAll().count() == 0) {

            val testImage = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAARElEQVR42u3PMREAAAgEoLd/YEfN4OpBA2qSzgMlIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiInKxnANiP8ezyscAAAAASUVORK5CYII="

            val resource = Resource().buildFromBase64(testImage)

            resourceRepo.save(resource)

            trafficViolRepo.save(TrafficViolation(Location("test loc", 54544, 3234), ViolationType.SPEED, LocalDateTime.now(), resource))

            val party = Party("USAL", null, "30537899901")
            partyRepo.save(party)

            val vehicle = Vehicle(party, "123456")
            vehicleRepo.save(vehicle)

            val parkingPlace = Place("place1",PlaceType.PARKING)
            val trafficLightPlace = Place("place2",PlaceType.TRAFFIC_LIGHT)

            placeRepo.save(parkingPlace)
            placeRepo.save(trafficLightPlace)

            checkpointRepo.save(Checkpoint(vehicle, parkingPlace))
            checkpointRepo.save(Checkpoint(vehicle, trafficLightPlace))

            val streetX1 = Street("x1", CardinalDirection.N)
            val streetX2 = Street("x2", CardinalDirection.S)
            val streetY1 = Street("y1", CardinalDirection.E)
            val streetY2 = Street("y2", CardinalDirection.O)

            streetRepo.save(streetX1)
            streetRepo.save(streetX2)
            streetRepo.save(streetY1)
            streetRepo.save(streetY2)

            trafficLightRepo.save(TrafficLight("1",TrafficLightStatus.CHANGE_GO, streetX1, streetY1))
            trafficLightRepo.save(TrafficLight("2",TrafficLightStatus.CHANGE_STOP, streetY1, streetX1))
        }

    }
}
