package de.cku.sglh.eventplanner

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EventPlannerApplication

fun main(args: Array<String>) {
    runApplication<EventPlannerApplication>(*args)
}
