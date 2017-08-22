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

    /*@ResponseBody
    @RequestMapping(value = "/resources/{id}")
    fun findOneResource(@PathVariable("id") id : Long): ResponseEntity<ByteArray> {
        return ResponseEntity.ok(resourceRepo.findOne(id).bytes)
    }*/

    /*@ResponseBody
    @RequestMapping(value = "/resources/{id}")
    fun findOneResource(@PathVariable("id") id: Long): FileOutputStream {

        val resource = resourceRepo.findOne(id)
        val path = Files.write(Paths.get("/tmp/filename"), resource.bytes)


        return FileOutputStream(path.toFile())
//        return FileSystemResource(path.toFile()).outputStream

//        val headers = HttpHeaders();
//        headers.contentType = MediaType.IMAGE_GIF;
//        return ResponseEntity<ByteArray>(resource.bytes, headers, HttpStatus.OK);
    }*/


//    @ResponseBody
//    @RequestMapping(value = "/resources/{id}")
//    fun findOneResource(@PathVariable("id") id : Long, response: HttpServletResponse): OutputStream {
//         val jpegOutputStream = ByteArrayOutputStream();
//    val resource = resourceRepo.findOne(id)
//
//    response.reset();
//    response.setBufferSize(DEFAULT_BUFFER_SIZE);
//    response.setContentType("image/png"); //or whatever file type you want to send.
//    try {
//        response.getOutputStream().write(resource.bytes);
//    } catch (e: IOException) {
//        // Do something
//    }

    @RequestMapping(
        value = "/resources/{id}",
        method = arrayOf(RequestMethod.GET)
//        produces = arrayOf(MediaType.APPLICATION_OCTET_STREAM_VALUE)
    )
    fun findOneResource(@PathVariable("id") id: Long): ResponseEntity<ByteArray> {
        val resource = resourceRepo.findOne(id)

        val headers = HttpHeaders()
        headers.contentType = resource.mediaType
        return ResponseEntity<ByteArray>(resource.bytes, headers, HttpStatus.OK)
    }
}
