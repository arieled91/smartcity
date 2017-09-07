package ar.edu.usal.smartcity.controller

import ar.edu.usal.smartcity.model.city.Checkpoint
import ar.edu.usal.smartcity.repository.CheckpointRepository
import ar.edu.usal.smartcity.repository.PlaceRepository
import ar.edu.usal.smartcity.repository.VehicleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "/api")
class CheckpointController {

    @Autowired lateinit var checkpointRepo: CheckpointRepository
    @Autowired lateinit var vehicleRepo: VehicleRepository
    @Autowired lateinit var placeRepo: PlaceRepository


    @RequestMapping(value = "/tags", method = arrayOf(RequestMethod.POST))
    fun saveCheckpoint(@RequestBody request: CheckpointRequest): HttpStatus {
        val vehicle = vehicleRepo.findByTagId(request.tagCode)
        val place = placeRepo.findByName(request.placeName)
        checkpointRepo.save(Checkpoint(vehicle, place))
        return HttpStatus.OK

    }

    open class CheckpointRequest(
        var placeName: String = "",
        var tagCode: String = ""
    )
}