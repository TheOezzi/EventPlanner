package de.cku.sglh.eventplanner.view

import de.cku.sglh.eventplanner.persistence.EventEntity
import de.cku.sglh.eventplanner.persistence.toDateStringForPicker

class DetailViewModel private constructor(
    val name: String,
    val location: String,
    val date: String,
    val attendees: String,
    val id: Long,
) {
    companion object {
        fun from(entity: EventEntity): DetailViewModel {
            return DetailViewModel(
                name = entity.name,
                location = entity.location,
                date = entity.date!!.toDateStringForPicker(),
                attendees = entity.attendees,
                id = entity.id
            )
        }
    }
}