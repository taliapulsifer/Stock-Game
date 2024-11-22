import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class APIController {
    @GetMapping("/endpoint")
    public Map<String, String> getEndpoint() {
        return Map.of("Message", "Hello from Spring Boot!");
    }
}
