package com.example.HabibAlizadaU1Capstone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class SecureAppController {


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loggedIn(Principal principal) {
        return "You are logged in as " + principal.getName();
    }


    @RequestMapping(value = "/alldone", method = RequestMethod.GET)
    public String allDone() {
        return "You are logged out!";
    }


}
