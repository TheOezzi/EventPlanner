package de.cku.sglh.eventplanner.model

import de.cku.sglh.eventplanner.persistence.*
import java.util.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
internal class EventModel @Autowired constructor(
    private val eventRepository: EventRepository,
    private val transactionHandler: TransactionHandler,
) {
    fun getAll(): List<EventEntity> {
        return transactionHandler.execute {
            eventRepository.findAll().toList()
        }
    }
    fun createNewEvent(
        withName: String,
        andLocation: String,
        andDate: Date,
        andAttendees: List<String>,
    ) {
        transactionHandler.execute {
            val event = EventEntity().apply {
                name = withName
                location = andLocation
                date = andDate
                attendees = andAttendees.joinToString()
            }
            eventRepository.save(event)
        }
    }

    fun editEvent(
        withId: Long,
        newName: String? = null,
        newLocation: String? = null,
        newDate: Date? = null,
    ) {
        transactionHandler.execute {
            eventRepository.findByIdOrNull(withId)?.let { event ->
                newName?.let {
                    event.name = newName
                }
                newLocation?.let {
                    event.location = newLocation
                }
                newDate?.let {
                    event.date = newDate
                }
                eventRepository.save(event)
            }
        }
    }

    fun removeEvent(withId: Long) {
        transactionHandler.execute {
            eventRepository.deleteById(withId)
        }
    }

    fun addAttendeeToEvent(withEventId: Long, attendee: String) {
        transactionHandler.execute {
            eventRepository.findByIdOrNull(withEventId)?.let { event ->
                val attendees = event.attendees.split(", ").toMutableList()
                attendees.add(attendee)
                event.attendees = attendees.joinToString()
                eventRepository.save(event)
            }
        }
    }

    fun removeAttendee(withEventId: Long, attendee: String) {
        transactionHandler.execute {
            eventRepository.findByIdOrNull(withEventId)?.let { event ->
                val attendees = event.attendees.split(", ").toMutableList()
                attendees.removeIf { it == attendee }
                event.attendees = attendees.joinToString()
                eventRepository.save(event)
            }
        }
    }
}