package dai.genkin.genkinweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ionutciuta24@gmail.com on 12.08.2017.
 */
@Controller
@RequestMapping("/")
public class AppController {

    @GetMapping
    public String get() {
        return "index.html";
    }
}
