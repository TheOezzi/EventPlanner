package de.cku.sglh.eventplanner.view

import de.cku.sglh.eventplanner.persistence.EventEntity
import de.cku.sglh.eventplanner.persistence.toDateStringForList

class ListViewModel private constructor(
    val events: List<EventViewModel>,
) {
    companion object {
        fun from(events: List<EventEntity>): ListViewModel {
            return ListViewModel(
                events.map(EventViewModel::from)
            )
        }
    }
}

class EventViewModel private constructor(
    val id: Long,
    val name: String,
    val location: String,
    val date: String,
    val attendees: String,
) {
    companion object {
        fun from(entity: EventEntity): EventViewModel {
            return EventViewModel(
                name = entity.name,
                location = entity.location,
                date = entity.date!!.toDateStringForList(),
                attendees = entity.attendees,
                id = entity.id
            )
        }
    }
}