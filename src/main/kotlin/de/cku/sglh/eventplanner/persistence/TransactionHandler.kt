package de.cku.sglh.eventplanner.persistence

import de.cku.sglh.eventplanner.exception.EventPlannerException
import de.cku.sglh.eventplanner.exception.EventPlannerExceptionCodes
import mu.KotlinLogging
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

private val Log = KotlinLogging.logger { }

@Service
internal class TransactionHandler {
    @Transactional(rollbackFor = [EventPlannerException::class])
    fun <T> execute(transaction: () -> T): T {
        return try {
            transaction()
        } catch (e: Exception) {
            Log.error(e) { "Something went wrong while trying to access the DB: ${e.localizedMessage}" }
            throw EventPlannerException(
                errorId = EventPlannerExceptionCodes.DATABASE_INTERACTION_FAILED,
                errorMessage = e.localizedMessage
            )
        }
    }
}
