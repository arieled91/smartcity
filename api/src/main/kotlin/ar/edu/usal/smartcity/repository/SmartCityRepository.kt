package ar.edu.usal.smartcity.repository

import ar.edu.usal.smartcity.model.city.*
import ar.edu.usal.smartcity.model.common.Resource
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import java.time.LocalDateTime

interface CheckpointRepository : CrudRepository<Checkpoint, Long>, PagingAndSortingRepository<Checkpoint, Long>

interface TagRepository : CrudRepository<Tag, Long>, PagingAndSortingRepository<Tag, Long> {
    fun findByCode(@Param("code") code: String): Tag
}

interface ResourceRepository : CrudRepository<Resource, Long>, PagingAndSortingRepository<Resource, Long>

interface TrafficViolationRepository : CrudRepository<TrafficViolation, Long>, PagingAndSortingRepository<TrafficViolation, Long>

interface TrafficLightRepository : CrudRepository<TrafficLight, String>, PagingAndSortingRepository<TrafficLight, String>, JpaSpecificationExecutor<TrafficLight> {
    fun findByStatusAndUpdateTimeLessThan(@Param("status") status: TrafficLightStatus,@Param("updateTime") updateTime: LocalDateTime): List<TrafficLight>
}