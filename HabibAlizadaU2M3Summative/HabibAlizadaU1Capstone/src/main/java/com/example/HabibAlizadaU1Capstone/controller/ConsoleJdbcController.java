package com.example.HabibAlizadaU1Capstone.controller;


import com.example.HabibAlizadaU1Capstone.dao.ConsoleDao;
import com.example.HabibAlizadaU1Capstone.model.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/console")
public class ConsoleJdbcController {

    @Autowired
    ConsoleDao consoleDao;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Console createConsole(@RequestBody @Valid Console console, Principal principal){
        System.out.println("Hello " + principal.getName() + "! Looks like you're logged in!");
        return consoleDao.addConsole(console);
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Console getConsole(@PathVariable("id") int consoleId){
       return consoleDao.getConsole(consoleId);
    }

    @GetMapping("/manufacturer/{manufacturer}")
    @ResponseStatus(HttpStatus.OK)
    public List<Console> getConsoleByManufacturer(@PathVariable("manufacturer") String manufacturer){
        return consoleDao.getConsoleByManufacturer(manufacturer);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Console> getAllConsoles(){
        return consoleDao.getAllConsole();
    }

    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable("id") int consoleId, Principal principal) {
        System.out.println("Hello " + principal.getName() + "! Looks like you're logged in!");
        consoleDao.deleteConsole(consoleId);
    }

    @PutMapping("/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateConsole(@PathVariable("id") int consoleId, @RequestBody @Valid Console console, Principal principal) {
        System.out.println("Hello " + principal.getName() + "! Looks like you're logged in!");
        if (console.getConsoleId() == 0)
            console.setConsoleId(consoleId);
        if (consoleId != console.getConsoleId()) {
            throw new IllegalArgumentException("Console ID on path must match the ID in the Console object");
        }
        consoleDao.updateConsole(console);
    }
}













