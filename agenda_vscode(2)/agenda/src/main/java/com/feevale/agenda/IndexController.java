package com.feevale.agenda;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping(value = { "", "/", "index", "/index" })
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("index");
        model.addObject("msg", "Ola mundo spring boot");

        return model;
    }

}
