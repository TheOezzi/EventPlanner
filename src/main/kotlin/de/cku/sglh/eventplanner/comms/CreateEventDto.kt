package de.cku.sglh.eventplanner.comms

data class CreateEventDto(
    val name: String,
    val location: String,
    val date: String,
    val attendees: String
)