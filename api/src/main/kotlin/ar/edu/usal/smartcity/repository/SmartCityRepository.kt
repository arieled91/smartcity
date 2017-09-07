package ar.edu.usal.smartcity.repository

import ar.edu.usal.smartcity.model.city.*
import ar.edu.usal.smartcity.model.common.Resource
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import java.time.LocalDateTime

interface CheckpointRepository : CrudRepository<Checkpoint, Long>, PagingAndSortingRepository<Checkpoint, Long>

interface ResourceRepository : CrudRepository<Resource, Long>, PagingAndSortingRepository<Resource, Long>

interface TrafficViolationRepository : CrudRepository<TrafficViolation, Long>, PagingAndSortingRepository<TrafficViolation, Long>

interface TrafficLightRepository : CrudRepository<TrafficLight, String>, PagingAndSortingRepository<TrafficLight, String>, JpaSpecificationExecutor<TrafficLight> {
    fun findByStatusAndUpdateTimeLessThan(@Param("status") status: TrafficLightStatus,@Param("updateTime") updateTime: LocalDateTime): List<TrafficLight>

//    @Query("select * from #{#TrafficLight} T where T.direction = :direction or T")
    @Query("SELECT T FROM CITY.TRAFFIC_LIGHT T \n" +
            "JOIN CITY.STREET POS ON POSITION_ID = POS.ID \n" +
            "JOIN CITY.STREET INT ON INTERSECTION_ID = INT.ID \n" +
            "WHERE POS.DIRECTION LIKE 'N' OR POS.DIRECTION LIKE 'S'\n" +
            "OR INT.ID IS NULL")
    fun findWithoutIntersection(): List<TrafficLight>

    fun findByPositionAndIntersection(@Param("position") position: Street, @Param("intersection") intersection: Street): TrafficLight
}

interface VehicleRepository : CrudRepository<Vehicle, Long>, PagingAndSortingRepository<Vehicle, Long>{
    fun findByTagId(@Param("tagId") tagId: String): Vehicle
}

interface PartyRepository : CrudRepository<Party, Long>, PagingAndSortingRepository<Party, Long>

interface StreetRepository : CrudRepository<Street, Long>, PagingAndSortingRepository<Street, Long>

interface PlaceRepository : CrudRepository<Place, Long>, PagingAndSortingRepository<Place, Long>{
    fun findByName(@Param("name") name: String): Place
}