package ar.edu.usal.smartcity.application.repository

import ar.edu.usal.smartcity.application.model.Tag
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository

interface TagRepository : CrudRepository<Tag, Long>, PagingAndSortingRepository<Tag, Long>