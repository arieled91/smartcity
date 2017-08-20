package ar.edu.usal.smartcity.persistance

import ar.edu.usal.common.Dev
import ar.edu.usal.smartcity.model.city.Checkpoint
import ar.edu.usal.smartcity.model.common.Location
import ar.edu.usal.smartcity.model.city.Tag
import ar.edu.usal.smartcity.model.city.TagType
import ar.edu.usal.smartcity.model.common.Resource
import ar.edu.usal.smartcity.repository.CheckpointRepository
import ar.edu.usal.smartcity.repository.ResourceRepository
import ar.edu.usal.smartcity.repository.TagRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.nio.charset.Charset
import java.util.*


@Dev
@Component
class DatabaseLoader : CommandLineRunner {

    @Autowired lateinit var checkpointRepo: CheckpointRepository
    @Autowired lateinit var tagRepo: TagRepository
    @Autowired lateinit var resourceRepo: ResourceRepository

    override fun run(vararg args: String?) {


        if (tagRepo.findAll().count() == 0) {
            val imageBytes: ByteArray = Base64.getEncoder().encode((
                "data:image/gif;base64,R0lGODlhEAAQAOYAAIAAD8jIyP8A/4ODg25CTff397cACY2Njebm5mZmZry8vMkmNq" +
                    "MfLKt2fbQiMcFsc9/f36dET86Kj7V+h3gWIKg9SJprctyqrMmZmv///7p6geDHyruLke/v75wpNrZNVah1fcycoqt/iJQP" +
                    "HOCFh+vT1N5ydJsADMwBBeK7voIYI9QoOZeAhcUAB817gczMzKwuN+XIzOrb3pIADaVNV7V7jK59heO1uK1CSrAeJ7gtNfDn6K" +
                    "2DjNSJjuLN0HRCTs0nN6VCSr9MVIwZIe3c3rWEjAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
                    "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
                    "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACH5BAEHAAIALAAAAAAQABAAA" +
                    "AejgAKCHhGFhoUxgooCGgiOjwgvGRuCCyuXmJdACAoZkwIOoaKjEJ0ZBRwMqqusEAEDCQcWQxS1trUqEBAvCi8NihYBwgEYKCYd" +
                    "yB0TiiC6uhcoJMnKijbTHS0lHQXcy4LWyTcGPdzd1eUFOj05Qi4uKTyKIuUSJzAfDwwzFfGC8zsVRsRARyRDPwHzaAAIUc6Tp4P" +
                    "zZPhwSNGgoh8sMmrcyIJAIAA7").toByteArray())

            val resource = Resource(imageBytes)

            resourceRepo.save(resource)

            val testTagNumber = "123456"

            val location = Location("lugar de prueba")

            val testTag: Tag = tagRepo.save(Tag(testTagNumber, TagType.OTHER, location))

            checkpointRepo.save(Checkpoint("test-device", testTag))
            checkpointRepo.save(Checkpoint("test-device", testTag))
        }

    }
}
