package ar.edu.usal.smartcity.persistance

import ar.edu.usal.smartcity.model.Checkpoint
import ar.edu.usal.smartcity.model.Tag
import ar.edu.usal.smartcity.model.TagType
import ar.edu.usal.smartcity.repository.CheckpointRepository
import ar.edu.usal.smartcity.repository.TagRepository
import ar.edu.usal.common.Dev
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component


@Dev
@Component
class DatabaseLoader : CommandLineRunner {

    @Autowired lateinit var checkpointRepo: CheckpointRepository
    @Autowired lateinit var tagRepo: TagRepository

    override fun run(vararg args: String?) {

        val testTagNumber = "123456"

        if(tagRepo.findAll().count()==0) {
            val testTag: Tag = tagRepo.save(Tag("123456", TagType.OTHER, "lugar de prueba", "semaforo de prueba"))

            checkpointRepo.save(Checkpoint("test-device", testTag))
            checkpointRepo.save(Checkpoint("test-device", testTag))
        }

    }
}
