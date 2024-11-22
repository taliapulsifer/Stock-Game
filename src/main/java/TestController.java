import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class TestController {
    @GetMapping("/test")
    public Map<String, String> getTestMessage() {
        return Map.of("message", "Hello World");
    }
}
