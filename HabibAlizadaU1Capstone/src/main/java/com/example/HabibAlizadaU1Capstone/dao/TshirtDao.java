package com.example.HabibAlizadaU1Capstone.dao;

import com.example.HabibAlizadaU1Capstone.model.Tshirt;

import java.util.List;

public interface TshirtDao {
    Tshirt addTshirt(Tshirt tshirt);
    Tshirt getTshirt(int id);
    List<Tshirt> getAllTshirt();
    void updateTshirt(Tshirt tshirt);
    void deleteTshirt(int id);
    List<Tshirt> getTshirtByColor(String color);
    List<Tshirt> getTshirtBySize(String size);


}
