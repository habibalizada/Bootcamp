package com.example.HabibAlizadaU1Capstone.dao;

import com.example.HabibAlizadaU1Capstone.model.Tshirt;
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
public class TshirtDaoTest {

    @Autowired
    TshirtDao tshirtDao;

    @Before
    public void setUp() throws Exception {

        List<Tshirt> tshirtList = tshirtDao.getAllTshirt();
        for (Tshirt tshirt : tshirtList){
            tshirtDao.deleteTshirt(tshirt.gettShirtId());
        }
    }

    @Test
    public void addGetDeleteTshirt() {

        Tshirt tshirt = new Tshirt();
        tshirt.setSize("Large");
        tshirt.setColor("Black");
        tshirt.setDescription("Very good t-shirt");
        tshirt.setPrice(24.99);
        tshirt.setQuantity(50);

        tshirt = tshirtDao.addTshirt(tshirt);

        Tshirt tshirt1 = tshirtDao.getTshirt(tshirt.gettShirtId());

        assertEquals(tshirt1, tshirt);

        tshirtDao.deleteTshirt(tshirt.gettShirtId());

        tshirt1 = tshirtDao.getTshirt(tshirt.gettShirtId());

        assertNull(tshirt1);
    }

    @Test
    public void updateTshirt() {

        Tshirt tshirt = new Tshirt();
        tshirt.setSize("Large");
        tshirt.setColor("Black");
        tshirt.setDescription("Very good t-shirt");
        tshirt.setPrice(24.99);
        tshirt.setQuantity(50);

        tshirt = tshirtDao.addTshirt(tshirt);

        tshirt.setSize("Small");
        tshirt.setColor("Red");
        tshirt.setDescription("Very good t-shirt");
        tshirt.setPrice(24.99);
        tshirt.setQuantity(20);

        tshirtDao.addTshirt(tshirt);

        Tshirt tshirt1 = tshirtDao.getTshirt(tshirt.gettShirtId());

        assertEquals(tshirt1, tshirt);
    }

    @Test
    public void getAllTshirt() {

        Tshirt tshirt = new Tshirt();
        tshirt.setSize("Large");
        tshirt.setColor("Black");
        tshirt.setDescription("Very good t-shirt");
        tshirt.setPrice(24.99);
        tshirt.setQuantity(50);

        tshirt = tshirtDao.addTshirt(tshirt);

        tshirt.setSize("Small");
        tshirt.setColor("Red");
        tshirt.setDescription("Very good t-shirt");
        tshirt.setPrice(24.99);
        tshirt.setQuantity(20);

        tshirtDao.addTshirt(tshirt);

        List<Tshirt> tshirtList = tshirtDao.getAllTshirt();
        assertEquals(tshirtList.size(),2);
    }

    @Test
    public void getTshirtByColor() {

        Tshirt tshirt = new Tshirt();
        tshirt.setSize("Large");
        tshirt.setColor("Black");
        tshirt.setDescription("Very good t-shirt");
        tshirt.setPrice(24.99);
        tshirt.setQuantity(50);

        tshirt = tshirtDao.addTshirt(tshirt);

        tshirt.setSize("Small");
        tshirt.setColor("Red");
        tshirt.setDescription("Very good t-shirt");
        tshirt.setPrice(24.99);
        tshirt.setQuantity(20);

        tshirtDao.addTshirt(tshirt);

        tshirt.setSize("Small");
        tshirt.setColor("Red");
        tshirt.setDescription("Very good t-shirt");
        tshirt.setPrice(24.99);
        tshirt.setQuantity(20);

        tshirtDao.addTshirt(tshirt);

        List<Tshirt> tshirtList = tshirtDao.getTshirtByColor("Red");
        assertEquals(tshirtList.size(),2);
    }

    @Test
    public void getTshirtBySize() {

        Tshirt tshirt = new Tshirt();
        tshirt.setSize("Large");
        tshirt.setColor("Black");
        tshirt.setDescription("Very good t-shirt");
        tshirt.setPrice(24.99);
        tshirt.setQuantity(50);

        tshirt = tshirtDao.addTshirt(tshirt);

        tshirt.setSize("Small");
        tshirt.setColor("Red");
        tshirt.setDescription("Very good t-shirt");
        tshirt.setPrice(24.99);
        tshirt.setQuantity(20);

        tshirtDao.addTshirt(tshirt);

        tshirt.setSize("Small");
        tshirt.setColor("Red");
        tshirt.setDescription("Very good t-shirt");
        tshirt.setPrice(24.99);
        tshirt.setQuantity(20);

        tshirtDao.addTshirt(tshirt);

        List<Tshirt> tshirtList = tshirtDao.getTshirtBySize("Small");
        assertEquals(tshirtList.size(), 2);

    }
}









































