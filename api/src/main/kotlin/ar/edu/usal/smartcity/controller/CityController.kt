package ar.edu.usal.smartcity.controller

import ar.edu.usal.smartcity.model.city.Tag
import ar.edu.usal.smartcity.model.city.TrafficViolation
import ar.edu.usal.smartcity.model.city.ViolationType
import ar.edu.usal.smartcity.model.common.Location
import ar.edu.usal.smartcity.model.common.Resource
import ar.edu.usal.smartcity.repository.CheckpointRepository
import ar.edu.usal.smartcity.repository.ResourceRepository
import ar.edu.usal.smartcity.repository.TagRepository
import ar.edu.usal.smartcity.repository.TrafficViolationRepository
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
    @Autowired lateinit var tagRepo: TagRepository
    @Autowired lateinit var trafficViolRepo: TrafficViolationRepository
    @Autowired lateinit var resourceRepo: ResourceRepository


    @RequestMapping(value = "/checkpointTags", method = arrayOf(RequestMethod.POST))
    fun saveCheckpoint(@RequestBody request: CheckpointRequest): ResponseEntity<Tag> {
        val tag = tagRepo.findByCode(request.tagCode)
        val saved = checkpointRepo.save(Tag(request.deviceId, tag, request.dateTime))
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
    var deviceId: String = "",
    var tagCode: String = "",
    var dateTime: LocalDateTime = LocalDateTime.now()
)

open class TrafficViolationRequest(
    var image: String,
    var location: Location,
    var dateTime: LocalDateTime,
    var violationType: ViolationType
)