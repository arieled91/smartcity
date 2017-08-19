package ar.edu.usal.smartcity.repository

import ar.edu.usal.smartcity.model.Checkpoint
import ar.edu.usal.smartcity.model.Tag
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param


interface TagRepository : CrudRepository<Tag, Long>, PagingAndSortingRepository<Tag, Long>{
    fun findByCode(@Param("code") code : String) : Tag
}