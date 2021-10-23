package de.cku.sglh.eventplanner.exception

import java.util.*
import mu.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

private val Log = KotlinLogging.logger { }
@RestControllerAdvice
internal class EventPlannerAdvice {
    @ExceptionHandler(EventPlannerException::class)
    fun handleCustomException(exception: EventPlannerException): ResponseEntity<EventPlannerExceptionDto> {
        val logId = UUID.randomUUID()
        Log.warn(exception) { "Something went wrong: ${exception.errorMessage} Refer to this logId: $logId." }
        return ResponseEntity<EventPlannerExceptionDto>(
            EventPlannerExceptionDto(
                errorId = exception.errorId,
                logId = logId.toString(),
                errorMessage = exception.errorMessage
            ),
            exception.statusCode
        )
    }
}