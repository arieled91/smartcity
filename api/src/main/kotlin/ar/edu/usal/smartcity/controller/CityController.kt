package ar.edu.usal.smartcity.controller

import ar.edu.usal.smartcity.model.city.Checkpoint
import ar.edu.usal.smartcity.repository.CheckpointRepository
import ar.edu.usal.smartcity.repository.TagRepository
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


    @RequestMapping(value = "/checkpointTags", method = arrayOf(RequestMethod.POST))
    fun saveCheckpoint(@RequestBody request: TagCheckpoint): ResponseEntity<Checkpoint> {
        val tag = tagRepo.findByCode(request.tagCode)
        return ResponseEntity.ok(checkpointRepo.save(Checkpoint(request.deviceId, tag, request.dateTime)))
    }
}

open class TagCheckpoint(
    var deviceId: String = "",
    var tagCode: String = "",
    var dateTime: LocalDateTime = LocalDateTime.now()
)