package ar.edu.usal.smartcity.controller

import ar.edu.usal.smartcity.repository.ResourceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api")
class ResourceController {

    @Autowired lateinit var resourceRepo: ResourceRepository

    @RequestMapping(
        value = "/resources/{id}",
        method = arrayOf(RequestMethod.GET)
    )
    fun findOneResource(@PathVariable("id") id: Long): ResponseEntity<ByteArray> {
        val resource = resourceRepo.findOne(id)

        val headers = HttpHeaders()
        headers.contentType = resource.mediaType
        return ResponseEntity<ByteArray>(resource.bytes, headers, HttpStatus.OK)
    }
}
