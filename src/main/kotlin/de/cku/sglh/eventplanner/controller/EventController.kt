package de.cku.sglh.eventplanner.controller

import de.cku.sglh.eventplanner.comms.CreateEventDto
import de.cku.sglh.eventplanner.comms.toDate
import de.cku.sglh.eventplanner.model.EventModel
import de.cku.sglh.eventplanner.view.EventsViewModel
import java.awt.PageAttributes
import java.time.LocalDate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping("events")
internal class EventController @Autowired constructor(
    private val eventModel: EventModel
) {
    @GetMapping("list")
    fun list(): ModelAndView {
       return ModelAndView(
           "list",
           mapOf("model" to EventsViewModel(eventModel.getAll()))
       )
    }

    @GetMapping("detail/{eventId}")
    fun details(@PathVariable eventId: Long): ModelAndView {
        val event = eventModel.getById(eventId)
        return ModelAndView(
            "detail",
            mapOf("event" to event)
        )
    }

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun create(@RequestBody eventDto: CreateEventDto) {
        eventModel.createNewEvent(
            withName = eventDto.name,
            andDate = eventDto.date.toDate(),
            andLocation = eventDto.location,
            andAttendees = eventDto.attendees.split(", ")
        )
    }

    @DeleteMapping("{eventId}")
    fun deleteEventWith(@PathVariable eventId: Long) {
        eventModel.removeEvent(eventId)
    }

    @GetMapping("create")
    fun createPage() : ModelAndView {
        return ModelAndView("create")
    }
}