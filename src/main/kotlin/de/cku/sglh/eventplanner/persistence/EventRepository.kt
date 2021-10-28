package de.cku.sglh.eventplanner.persistence

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional(propagation = Propagation.REQUIRED)
internal interface EventRepository : CrudRepository<EventEntity, Long> {
    fun findAllByOrderByDateAsc(): List<EventEntity>
}