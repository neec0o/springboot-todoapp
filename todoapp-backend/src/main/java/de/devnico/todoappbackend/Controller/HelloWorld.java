package de.devnico.todoappbackend.Controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class HelloWorld {

    @GetMapping(value = "/hello", produces = MediaType.TEXT_PLAIN_VALUE)
    public String hello() {
        return "Hello World";
    }

    @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> json() {
        HashMap<String, String> map = new HashMap<>();
        map.put("message", "Hello World");
        return map;
    }

    @GetMapping(value = "/html", produces = MediaType.TEXT_HTML_VALUE)
    public String html() {
        return "<h1>Hello World</h1>";
    }

    @GetMapping(value ="/getmp4", produces = "video/mp4")
    public ResponseEntity<byte[]> getmp4() throws IOException {
        try (var resource = new ClassPathResource("assets/mp4/vid.mp4").getInputStream()) {
            byte[] vidBytes = resource.readAllBytes();
            return ResponseEntity.ok(vidBytes);
        }
    }

    @GetMapping(value = "/getImage", produces = "image/jpg")
    public ResponseEntity<byte[]> getImage() throws IOException {
        try (var resource = new ClassPathResource("assets/images/oscar.jpg").getInputStream()) {
            byte[] imageBytes = resource.readAllBytes();
            return ResponseEntity.ok(imageBytes);
        }
    }
}
