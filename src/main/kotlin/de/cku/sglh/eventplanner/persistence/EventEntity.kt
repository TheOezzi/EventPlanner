package de.cku.sglh.eventplanner.persistence

import de.cku.sglh.eventplanner.exception.EventPlannerException
import de.cku.sglh.eventplanner.persistence.EventEntity.Companion.COLUMN_NAME_ID
import de.cku.sglh.eventplanner.persistence.EventEntity.Companion.TABLE_NAME_EVENT
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.persistence.*

@Entity
@Table(
    name = TABLE_NAME_EVENT,
    uniqueConstraints = [
        UniqueConstraint(columnNames = [COLUMN_NAME_ID])
    ]
)

open class EventEntity {
    companion object {
        const val TABLE_NAME_EVENT = "events"
        const val COLUMN_NAME_ID = "ID"
        const val COLUMN_NAME_NAME = "NAME"
        const val COLUMN_NAME_LOCATION = "LOCATION"
        const val COLUMN_NAME_DATE = "DATE"
        const val COLUMN_NAME_ATTENDEES = "ATTENDEES"
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = COLUMN_NAME_ID, nullable = false)
    open var id: Long = 0

    @Column(name = COLUMN_NAME_NAME, nullable = false)
    open var name: String = ""

    @Column(name = COLUMN_NAME_LOCATION, nullable = false)
    open var location: String = ""

    @Column(name = COLUMN_NAME_DATE, nullable = false)
    open var date: LocalDateTime? = null

    @Column(name = COLUMN_NAME_ATTENDEES, nullable = false)
    open var attendees: String = ""
}

fun String.toDate(): LocalDateTime {
    val formatters = listOf(
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"),
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS")
    )

    for (formatter in formatters) {
        try {
            return LocalDateTime.parse(this, formatter)
        } catch (e: Exception) {
        }
    }
    throw EventPlannerException("", "")
}

fun LocalDateTime.toDateStringForPicker(): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")
    return this.format(formatter)
}

fun LocalDateTime.toDateStringForList(): String {
    val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")
    return this.format(formatter)
}