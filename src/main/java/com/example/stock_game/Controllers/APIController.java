//A controller is part of the presentation layer of your application. It handles incoming HTTP requests, processes user
//input, and returns a response. Focuses on the communication between the user and the application.
//Controllers DO NOT contain business logic or directly manipulate data. Controllers rely on services for business
//logic and data access.

package com.example.stock_game.Controllers;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class APIController {
    @GetMapping("/endpoint") //Handles HTTP 'GET' requests
    public Map<String, String> getEndpoint() {
        return Map.of("Message", "Hello from Spring Boot!");
    }
}
