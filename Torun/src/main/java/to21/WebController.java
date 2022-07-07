package to21;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    @RequestMapping("/")
    public String jspcheck(Model model) {
        System.out.println("WebController 들어옴");
        model.addAttribute("message", "티오 스터디입니다.");
        return "index";
    }
}
