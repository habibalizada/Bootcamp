package com.trilogyed.tasker.dao;

import com.trilogyed.tasker.model.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaskerDaoTest {

    @Autowired
    TaskerDao taskerDao;

    @Before
    public void seUp() throws Exception{
        List<Task> taskList = taskerDao.getAllTasks();
        for (Task task : taskList){
            taskerDao.deleteTask(task.getId());
        }
    }

    @Test
    public void addGetDeleteTask(){

        Task task = new Task();
        task.setDescription("Do the homework");
        task.setCreateDate(LocalDate.of(2019, 07, 1));
        task.setDueDate(LocalDate.of(2019, 07, 8));
        task.setCategory("School");

        task = taskerDao.createTask(task);

        Task task1 = taskerDao.getTask(task.getId());

        assertEquals(task1, task);

        taskerDao.deleteTask(task.getId());

        task1 = taskerDao.getTask(task.getId());

        assertNull(task1);
    }

    @Test
    public void getAllTasks(){

        Task task = new Task();
        task.setDescription("Do the homework");
        task.setCreateDate(LocalDate.of(2019, 07, 1));
        task.setDueDate(LocalDate.of(2019, 07, 8));
        task.setCategory("School");

        task = taskerDao.createTask(task);

        task = new Task();
        task.setDescription("Do the Summative");
        task.setCreateDate(LocalDate.of(2019, 07, 1));
        task.setDueDate(LocalDate.of(2019, 07, 8));
        task.setCategory("School");

        task = taskerDao.createTask(task);

        List<Task> taskList = taskerDao.getAllTasks();
        assertEquals(taskList.size(),2);

    }

    @Test
    public void getTasksByCategory(){

        Task task = new Task();
        task.setDescription("Do the homework");
        task.setCreateDate(LocalDate.of(2019, 07, 1));
        task.setDueDate(LocalDate.of(2019, 07, 8));
        task.setCategory("School");

        task = taskerDao.createTask(task);

        task = new Task();
        task.setDescription("Do the Summative");
        task.setCreateDate(LocalDate.of(2019, 07, 1));
        task.setDueDate(LocalDate.of(2019, 07, 8));
        task.setCategory("School");

        task = taskerDao.createTask(task);

        List<Task> taskList = taskerDao.getTasksByCategory("School");
        assertEquals(taskList.size(),2);
    }

    @Test
    public void updateTask(){

        Task task = new Task();
        task.setDescription("Do the homework");
        task.setCreateDate(LocalDate.of(2019, 07, 1));
        task.setDueDate(LocalDate.of(2019, 07, 8));
        task.setCategory("School");

        task = taskerDao.createTask(task);

        task.setDescription("Do the Summative");
        task.setCreateDate(LocalDate.of(2019, 07, 1));
        task.setDueDate(LocalDate.of(2019, 07, 8));
        task.setCategory("School");

        taskerDao.updateTask(task);

        Task task1 = taskerDao.getTask(task.getId());

        assertEquals(task1, task);

    }
}
