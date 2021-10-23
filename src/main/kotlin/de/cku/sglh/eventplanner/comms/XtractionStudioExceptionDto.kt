package de.cku.sglh.eventplanner.exception

internal data class EventPlannerExceptionDto(
    val errorId: String,
    val logId: String,
    val errorMessage: String?,
)
