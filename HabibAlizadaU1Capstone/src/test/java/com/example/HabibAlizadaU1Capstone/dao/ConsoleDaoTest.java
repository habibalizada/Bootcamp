package com.example.HabibAlizadaU1Capstone.dao;

import com.example.HabibAlizadaU1Capstone.model.Console;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConsoleDaoTest {

    @Autowired
    ConsoleDao consoleDao;

    @Before
    public void setUp() throws Exception {

        List<Console> consoleList = consoleDao.getAllConsole();
        for (Console console : consoleList){
            consoleDao.deleteConsole(console.getConsoleId());
        }

    }

    @Test
    public void addGetDeleteConsole() {

        Console console = new Console();
        console.setModel("PlayStation 4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("1TB");
        console.setProcessor("AMD x86-64");
        console.setPrice(299.99);
        console.setQuantity(10);

        console = consoleDao.addConsole(console);

        Console console1 = consoleDao.getConsole(console.getConsoleId());

        assertEquals(console1, console);

        consoleDao.deleteConsole(console.getConsoleId());

        console1 = consoleDao.getConsole(console.getConsoleId());

        assertNull(console1);
    }

    @Test
    public void updateConsole() {

        Console console = new Console();
        console.setModel("PlayStation 4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("1TB");
        console.setProcessor("AMD x86-64");
        console.setPrice(299.99);
        console.setQuantity(10);

        console = consoleDao.addConsole(console);

        console.setModel("Nintendo - Switch");
        console.setManufacturer("Nintendo");
        console.setMemoryAmount("32GB");
        console.setProcessor("NVIDIA");
        console.setPrice(299.99);
        console.setQuantity(20);

        consoleDao.addConsole(console);

        Console console1 = consoleDao.getConsole(console.getConsoleId());

        assertEquals(console1, console);
    }

    @Test
    public void getAllConsole() {
        Console console = new Console();
        console.setModel("PlayStation 4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("1TB");
        console.setProcessor("AMD x86-64");
        console.setPrice(299.99);
        console.setQuantity(10);

        consoleDao.addConsole(console);

        console.setModel("Nintendo - Switch");
        console.setManufacturer("Nintendo");
        console.setMemoryAmount("32GB");
        console.setProcessor("NVIDIA");
        console.setPrice(299.99);
        console.setQuantity(20);

        consoleDao.addConsole(console);

        List<Console> consoleList = consoleDao.getAllConsole();
        assertEquals(consoleList.size(), 2);

    }

    @Test
    public void getConsoleByManufacturer() {
        Console console = new Console();
        console.setModel("PlayStation 4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("1TB");
        console.setProcessor("AMD x86-64");
        console.setPrice(299.99);
        console.setQuantity(10);

        consoleDao.addConsole(console);

        console.setModel("Nintendo - Switch");
        console.setManufacturer("Nintendo");
        console.setMemoryAmount("32GB");
        console.setProcessor("NVIDIA");
        console.setPrice(299.99);
        console.setQuantity(20);

        consoleDao.addConsole(console);

        console.setModel("Nintendo - Switch");
        console.setManufacturer("Nintendo");
        console.setMemoryAmount("32GB");
        console.setProcessor("NVIDIA");
        console.setPrice(299.99);
        console.setQuantity(20);

        consoleDao.addConsole(console);

        List<Console> consoleList = consoleDao.getConsoleByManufacturer("Nintendo");
        assertEquals(consoleList.size(),2);



    }
}
