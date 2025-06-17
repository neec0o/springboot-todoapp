package de.devnico.todoappbackend.Controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PageNotFound {

    @GetMapping(value = "/404", produces = MediaType.TEXT_HTML_VALUE)
    public String notFound() {
        return "<h1>Page Not Found</h1>";
    }

}
