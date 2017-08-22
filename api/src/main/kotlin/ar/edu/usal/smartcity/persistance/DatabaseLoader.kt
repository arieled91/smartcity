package ar.edu.usal.smartcity.persistance

import ar.edu.usal.common.Dev
import ar.edu.usal.smartcity.model.city.Checkpoint
import ar.edu.usal.smartcity.model.city.Tag
import ar.edu.usal.smartcity.model.city.TagType
import ar.edu.usal.smartcity.model.common.Location
import ar.edu.usal.smartcity.model.common.Resource
import ar.edu.usal.smartcity.repository.CheckpointRepository
import ar.edu.usal.smartcity.repository.ResourceRepository
import ar.edu.usal.smartcity.repository.TagRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.util.*


@Dev
@Component
class DatabaseLoader : CommandLineRunner {

    @Autowired lateinit var checkpointRepo: CheckpointRepository
    @Autowired lateinit var tagRepo: TagRepository
    @Autowired lateinit var resourceRepo: ResourceRepository

    override fun run(vararg args: String?) {

        if (tagRepo.findAll().count() == 0) {

            val testImage = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAARElEQVR42u3PMREAAAgEoLd/YEfN4OpBA2qSzgMlIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiInKxnANiP8ezyscAAAAASUVORK5CYII="

            val resource = Resource().buildFromBase64(testImage)

            resourceRepo.save(resource)

            val testTagNumber = "123456"

            val location = Location("lugar de prueba")

            val testTag: Tag = tagRepo.save(Tag(testTagNumber, TagType.OTHER, location))

            checkpointRepo.save(Checkpoint("test-device", testTag))
            checkpointRepo.save(Checkpoint("test-device", testTag))
        }

    }
}
