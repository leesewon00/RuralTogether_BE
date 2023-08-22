package landvibe.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/test/login")
    public String loginForm() {
        return "loginForm";
    }

    @GetMapping("/test/main")
    public String blogs() {
        return "blogList";
    }

    @GetMapping(value = "/test/new")
    public String createForm() {
        return "createBlogForm";
    }
}
