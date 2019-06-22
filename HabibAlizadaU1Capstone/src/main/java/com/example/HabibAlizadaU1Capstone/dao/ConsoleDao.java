package com.example.HabibAlizadaU1Capstone.dao;

import com.example.HabibAlizadaU1Capstone.model.Console;

import java.util.List;

public interface ConsoleDao {
    Console addConsole(Console console);
    Console getConsole(int id);
    List<Console> getAllConsole();
    void updateConsole(Console console);
    void deleteConsole(int id);
    List<Console> getConsoleByManufacturer(String manufacturer);
}
