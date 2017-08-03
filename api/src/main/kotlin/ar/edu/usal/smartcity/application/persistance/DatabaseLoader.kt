package ar.edu.usal.smartcity.application.persistance

import ar.edu.usal.smartcity.application.model.Tag
import ar.edu.usal.smartcity.application.repository.TagRepository
import ar.edu.usal.smartcity.common.Dev
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component


@Dev @Component
class DatabaseLoader : CommandLineRunner {

    @Autowired lateinit var tagDao: TagRepository

    override fun run(vararg args: String?) {

        if(tagDao.findAll().count()==0) {
            this.tagDao.save(Tag("robotito-usal", "435454354"))
            this.tagDao.save(Tag("robotito-usal", "875652454"))
            this.tagDao.save(Tag("robotito-usal", "546456787"))
            this.tagDao.save(Tag("robotito-usal", "544524886"))
            this.tagDao.save(Tag("robotito-usal", "156786864"))
        }

    }
}
