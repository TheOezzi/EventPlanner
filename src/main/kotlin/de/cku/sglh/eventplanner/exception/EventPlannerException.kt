package de.cku.sglh.eventplanner.exception

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class EventPlannerException(
    val errorId: String,
    val errorMessage: String,
    val statusCode: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
) : ResponseStatusException(statusCode, "[$errorId]: $errorMessage")
