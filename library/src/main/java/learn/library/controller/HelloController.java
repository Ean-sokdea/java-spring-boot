package learn.library.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {
    @GetMapping("/hello")
    public String SayHello() {
        return "សួស្តីខ្មែរ! Spring Boot ដំបូងរបស់ខ្ញុំដំណើរការហើយ";
    }
    @GetMapping("/name")
    public String getName() {
        return "ខ្ញុំឈ្មោះ សុខា"; // ដាក់ឈ្មោះអ្នក
    }
    @GetMapping("/sum")
    public String sum() {
        int a = 15;
        int b = 27;
        return "15 + 27 = " + (a + b);
    }
}
