package de.cku.sglh.eventplanner.controller

import de.cku.sglh.eventplanner.comms.CreateEventDto
import de.cku.sglh.eventplanner.model.EventModel
import de.cku.sglh.eventplanner.persistence.toDate
import de.cku.sglh.eventplanner.view.DetailViewModel
import de.cku.sglh.eventplanner.view.ListViewModel
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
           mapOf("model" to ListViewModel.from(eventModel.getAll()))
       )
    }

    @GetMapping("detail/{eventId}")
    fun details(@PathVariable eventId: Long): ModelAndView {
        val event = eventModel.getById(eventId)
        return ModelAndView(
            "detail",
            mapOf("model" to DetailViewModel.from(event))
        )
    }

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun create(@RequestBody eventDto: CreateEventDto) {
        eventModel.createNewEvent(
            withName = eventDto.name,
            andDate = eventDto.date.toDate(),
            andLocation = eventDto.location,
            andAttendees = eventDto.attendees
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