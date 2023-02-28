package ru.kulakov.spring.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam(value = "number", required = false) Integer number1,
                                 @RequestParam(value = "number2", required = false) Integer number2,
                                 @RequestParam(value = "operation", required = false) String operation,
                                 Model model) {

        if ("sum".equals(operation)) {
            model.addAttribute("answer", "Answer : " + (number1 + number2));
        } else if ("minus".equals(operation)) {
            model.addAttribute("answer", "Answer : " + (number1 - number2));
        } else if ("umnozh".equals(operation)) {
            model.addAttribute("answer", "Answer : " + (number1 * number2));

        }else
        model.addAttribute("answer", "Answer : " + (number1 / number2));

        return "first/calculator";
    }
}
