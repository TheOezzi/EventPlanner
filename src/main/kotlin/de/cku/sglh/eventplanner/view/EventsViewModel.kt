package de.cku.sglh.eventplanner.view

import de.cku.sglh.eventplanner.persistence.EventEntity

data class EventsViewModel(
    val events: List<EventEntity>
)