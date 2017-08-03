package ar.edu.usal.smartcity.application.controller

import ar.edu.usal.smartcity.application.repository.TagRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
open class TagController {

    @Autowired lateinit var tagRepo: TagRepository

//    @CrossOrigin("*")
//    @RequestMapping("/events/{}")
//    open fun postEvents() : String
//    {
//
//    }
}