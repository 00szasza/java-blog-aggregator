package hu.szasza.jba.controller;

/**
 * Created by SzaSza on 2015.04.26..
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")

    public String login()
    {
        return "login";
    }
}
