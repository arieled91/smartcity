package ar.edu.usal.smartcity.controller

import ar.edu.usal.smartcity.repository.ResourceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody


@RepositoryRestController
class ResourceController {


    @Autowired lateinit var resourceRepo: ResourceRepository

    //todo make it work
    @ResponseBody
    @RequestMapping(value = "/resources/{id}")
    fun findOneResource(@PathVariable("id") id : Long): ByteArray {
        return resourceRepo.findOne(id).content
    }
}

