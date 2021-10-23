package de.cku.sglh.eventplanner.comms

import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class CreateEventDto(
    val name: String,
    val location: String,
    val date: String,
    val attendees: String
)

fun String.toDate(): LocalDate {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")
    return LocalDate.parse(this, formatter)
}