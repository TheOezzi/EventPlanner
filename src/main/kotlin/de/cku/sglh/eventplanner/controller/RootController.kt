package de.cku.sglh.eventplanner.controller

import javax.servlet.http.HttpServletResponse
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class RootController {
    @GetMapping
    fun redirectToList(request: HttpServletResponse) {
        request.sendRedirect("events/list")
    }
}