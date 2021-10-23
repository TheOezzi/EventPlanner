package de.cku.sglh.eventplanner.controller

import de.cku.sglh.eventplanner.model.EventModel
import de.cku.sglh.eventplanner.view.EventsViewModel
import java.util.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping("events")
internal class EventController @Autowired constructor(
    private val eventModel: EventModel
) {
    @GetMapping("list")
    fun list(): ModelAndView {
        eventModel.createNewEvent(
            withName = "Die Ärzte",
            andLocation = "Mannheim Maimarkt Gelände",
            andDate = Date(),
            andAttendees = listOf("Corvin", "Anni")
        )
       return ModelAndView("list", mapOf("model" to EventsViewModel(eventModel.getAll())))
    }
}