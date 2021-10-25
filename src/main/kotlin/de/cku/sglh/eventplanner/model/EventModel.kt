package de.cku.sglh.eventplanner.model

import de.cku.sglh.eventplanner.persistence.*
import java.time.LocalDateTime
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
internal class EventModel @Autowired constructor(
    private val eventRepository: EventRepository,
    private val transactionHandler: TransactionHandler,
) {
    fun createNewEvent(
        withName: String,
        andLocation: String,
        andDate: LocalDateTime,
        andAttendees: String,
    ) {
        transactionHandler.execute {
            val event = EventEntity().apply {
                name = withName
                location = andLocation
                date = andDate
                attendees = andAttendees
            }
            eventRepository.save(event)
        }
    }

    fun editEvent(
        withId: Long,
        newName: String,
        newLocation: String,
        newDate: String,
        newAttendees: String,
    ) {
        transactionHandler.execute {
            eventRepository.findByIdOrNull(withId)?.let { event ->
                eventRepository.save(event.apply {
                    event.name = newName
                    event.location = newLocation
                    event.date = newDate.toDate()
                    event.attendees = newAttendees
                })
            }
        }
    }

    fun removeEvent(withId: Long) {
        transactionHandler.execute {
            eventRepository.deleteById(withId)
        }
    }

    fun getAll(): List<EventEntity> {
        return transactionHandler.execute {
            eventRepository.findAll().toList()
        }
    }

    fun getById(eventId: Long) = transactionHandler.execute {
        eventRepository.findById(eventId).get()
    }
}