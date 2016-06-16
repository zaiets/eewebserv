package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {

    @RequestMapping(value = "/hello")
    public ModelAndView hello(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "Title 1");
        modelAndView.addObject("message", "Hello all!");
        modelAndView.setViewName("hello");
        return modelAndView;
    }

    @RequestMapping(value = "/hi")
    public ModelAndView hi(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "Title 2");
        modelAndView.addObject("message", "Hi my best friend!");
        modelAndView.setViewName("hi");
        return modelAndView;
    }
}
