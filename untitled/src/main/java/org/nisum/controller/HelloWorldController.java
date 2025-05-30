package org.nisum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

    @RequestMapping("/Hello")
    public ModelAndView handleHello() {
        String mssg = "Hello World!";
        // "message" is the attribute name, mssg is the value
        return new ModelAndView("Hello", "message", mssg);
    }
}
