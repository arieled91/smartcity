package ar.edu.usal.smartcity.repository

import ar.edu.usal.smartcity.model.city.Checkpoint
import ar.edu.usal.smartcity.model.city.Tag
import ar.edu.usal.smartcity.model.common.Resource
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param

interface CheckpointRepository : CrudRepository<Checkpoint, Long>, PagingAndSortingRepository<Checkpoint, Long>

interface TagRepository : CrudRepository<Tag, Long>, PagingAndSortingRepository<Tag, Long> {
    fun findByCode(@Param("code") code: String): Tag
}

interface ResourceRepository : CrudRepository<Resource, Long>, PagingAndSortingRepository<Resource, Long>