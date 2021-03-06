package com.initech.tps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * BaseController class to redirect to Swagger UI
 * */

@Controller
@RequestMapping("/")
public class BaseController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String forward() {
        return "redirect:/swagger-ui.html";
    }
}
