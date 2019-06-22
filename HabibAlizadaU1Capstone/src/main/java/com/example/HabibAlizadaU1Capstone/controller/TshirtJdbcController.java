package com.example.HabibAlizadaU1Capstone.controller;

import com.example.HabibAlizadaU1Capstone.dao.TshirtDao;
import com.example.HabibAlizadaU1Capstone.model.Console;
import com.example.HabibAlizadaU1Capstone.model.Tshirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tshirt")
public class TshirtJdbcController {

    @Autowired
    TshirtDao tshirtDao;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tshirt createTshirt(@RequestBody @Valid Tshirt tshirt){
        return tshirtDao.addTshirt(tshirt);
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Tshirt getTshirt(@PathVariable("id") int tshirtId){
        return tshirtDao.getTshirt(tshirtId);
    }

    @GetMapping("/color/{color}")
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirt> getTshirtByColor(@PathVariable("color") String color){
        return tshirtDao.getTshirtByColor(color);
    }

    @GetMapping("/size/{size}")
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirt> getTshirtBySize(@PathVariable("size") String size){
        return tshirtDao.getTshirtBySize(size);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirt> getAllTshirts(){
        return tshirtDao.getAllTshirt();
    }

    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTshirt(@PathVariable("id") int tshirtId) {
        tshirtDao.deleteTshirt(tshirtId);
    }

    @PutMapping("/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTshirt(@PathVariable("id") int tshirtId, @RequestBody @Valid Tshirt tshirt) {
        if (tshirt.gettShirtId() == 0)
            tshirt.settShirtId(tshirtId);
        if (tshirtId != tshirt.gettShirtId()) {
            throw new IllegalArgumentException("Tshirt ID on path must match the ID in the Tshirt object");
        }
        tshirtDao.updateTshirt(tshirt);
    }

}
