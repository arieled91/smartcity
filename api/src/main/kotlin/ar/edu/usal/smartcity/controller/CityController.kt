package ar.edu.usal.smartcity.controller

import ar.edu.usal.smartcity.model.city.Checkpoint
import ar.edu.usal.smartcity.model.city.TrafficViolation
import ar.edu.usal.smartcity.model.city.ViolationType
import ar.edu.usal.smartcity.model.common.Location
import ar.edu.usal.smartcity.model.common.Resource
import ar.edu.usal.smartcity.repository.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import java.time.LocalDateTime


@RepositoryRestController
class CityController {

    @Autowired lateinit var checkpointRepo: CheckpointRepository
    @Autowired lateinit var vehicleRepo: VehicleRepository
    @Autowired lateinit var trafficViolRepo: TrafficViolationRepository
    @Autowired lateinit var resourceRepo: ResourceRepository
    @Autowired lateinit var placeRepo: PlaceRepository


    @RequestMapping(value = "/tags", method = arrayOf(RequestMethod.POST))
    fun saveCheckpoint(@RequestBody request: CheckpointRequest): ResponseEntity<Checkpoint> {
        val vehicle = vehicleRepo.findByTagId(request.tagCode)
        val place = placeRepo.findByName(request.placeName)
        val saved = checkpointRepo.save(Checkpoint(vehicle, place))
        return ResponseEntity.ok(saved)
    }

    @RequestMapping(value = "/trafficViolations", method = arrayOf(RequestMethod.POST))
    fun saveTrafficViolation(@RequestBody request: TrafficViolationRequest): ResponseEntity<TrafficViolation> {
        val image = resourceRepo.save(Resource().buildFromBase64(request.image))
        val saved = trafficViolRepo.save(TrafficViolation(request.location, request.violationType, request.dateTime, image))
        return ResponseEntity.ok(saved)
    }
}

open class CheckpointRequest(
    var placeName: String = "",
    var tagCode: String = ""
)

open class TrafficViolationRequest(
    var image: String,
    var location: Location,
    var dateTime: LocalDateTime,
    var violationType: ViolationType
)