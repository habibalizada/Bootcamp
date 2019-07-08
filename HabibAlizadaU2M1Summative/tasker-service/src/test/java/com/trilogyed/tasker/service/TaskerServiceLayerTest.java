package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.dao.TaskerDaoJdbcTemplateImpl;
import com.trilogyed.tasker.feign.AdserverFeignClient;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TaskerServiceLayerTest {

    TaskerServiceLayer taskerServiceLayer;
    TaskerDao taskerDao;

    //@Autowired
    @Mock
    AdserverFeignClient client = mock(AdserverFeignClient.class);

    public TaskerServiceLayerTest() {
    }

    @Before
    public void seUp() throws Exception{
        setUpTaskerDaoMock();
        taskerServiceLayer = new TaskerServiceLayer(client, taskerDao);

        System.out.println(taskerServiceLayer);


    }

    @Test
    public void fetchTask(){
        TaskViewModel taskViewModel = new TaskViewModel();

        taskViewModel.setDescription("Do the homework");
        taskViewModel.setCreateDate(LocalDate.of(2019,7,1));
        taskViewModel.setDueDate(LocalDate.of(2019,7,9));
        taskViewModel.setCategory("School");
        taskViewModel.setAdvertisement(client.getAd());

        taskViewModel = taskerServiceLayer.newTask(taskViewModel);


        TaskViewModel taskViewModel1 = taskerServiceLayer.fetchTask(taskViewModel.getId());

        assertEquals(taskViewModel, taskViewModel1);
    }

    @Test
    public void fetchAllTasks(){
        TaskViewModel taskViewModel = new TaskViewModel();

        taskViewModel.setDescription("Do the homework");
        taskViewModel.setCreateDate(LocalDate.of(2019,7,1));
        taskViewModel.setDueDate(LocalDate.of(2019,7,9));
        taskViewModel.setCategory("School");
        taskViewModel.setAdvertisement(client.getAd());

        taskViewModel = taskerServiceLayer.newTask(taskViewModel);

        List<TaskViewModel> taskViewModelList = taskerServiceLayer.fetchAllTasks();

        assertEquals(taskViewModelList.size(), 1);
        assertEquals(taskViewModel, taskViewModelList.get(0));
    }

    @Test
    public void getTasksByCategory(){
        TaskViewModel taskViewModel = new TaskViewModel();

        taskViewModel.setDescription("Do the homework");
        taskViewModel.setCreateDate(LocalDate.of(2019,7,1));
        taskViewModel.setDueDate(LocalDate.of(2019,7,9));
        taskViewModel.setCategory("School");
        taskViewModel.setAdvertisement(client.getAd());

        taskViewModel = taskerServiceLayer.newTask(taskViewModel);

        List<TaskViewModel> taskViewModelList = taskerServiceLayer.fetchTasksByCategory("School");

        assertEquals(taskViewModelList.size(), 1);
        assertEquals(taskViewModel, taskViewModelList.get(0));
    }

    @Test
    public void newTask(){
        TaskViewModel taskViewModel = new TaskViewModel();

        taskViewModel.setDescription("Do the homework");
        taskViewModel.setCreateDate(LocalDate.of(2019,7,1));
        taskViewModel.setDueDate(LocalDate.of(2019,7,9));
        taskViewModel.setCategory("School");
        taskViewModel.setAdvertisement(client.getAd());

        taskViewModel = taskerServiceLayer.newTask(taskViewModel);

        TaskViewModel taskViewModel1 = taskerServiceLayer.fetchTask(taskViewModel.getId());

        assertEquals(taskViewModel, taskViewModel1);
    }

    @Test
    public void deleteTask(){
        TaskViewModel taskViewModel = new TaskViewModel();

        taskViewModel.setDescription("Do the homework");
        taskViewModel.setCreateDate(LocalDate.of(2019,7,1));
        taskViewModel.setDueDate(LocalDate.of(2019,7,9));
        taskViewModel.setCategory("School");
        taskViewModel.setAdvertisement(client.getAd());

        Task task = new Task();
        task.setDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());
        task.setId(taskViewModel.getId());

        //assertEquals(taskViewModel1, taskViewModel);
        taskerDao.deleteTask(task.getId());
        verify(taskerDao, atLeast(1)).deleteTask(task.getId());

    }

    @Test
    public void updateTask(){
        TaskViewModel taskViewModel = new TaskViewModel();

        taskViewModel.setDescription("Do the homework");
        taskViewModel.setCreateDate(LocalDate.of(2019,7,1));
        taskViewModel.setDueDate(LocalDate.of(2019,7,9));
        taskViewModel.setCategory("School");
        taskViewModel.setAdvertisement(client.getAd());

        taskViewModel = taskerServiceLayer.newTask(taskViewModel);

        taskViewModel.setDescription("Do the Summative");
        taskViewModel.setCreateDate(LocalDate.of(2019,7,1));
        taskViewModel.setDueDate(LocalDate.of(2019,7,9));
        taskViewModel.setCategory("Bootcamp");
        taskViewModel.setAdvertisement(client.getAd());

        TaskViewModel taskViewModel1 = taskerServiceLayer.fetchTask(taskViewModel.getId());

        Task task = new Task();
        task.setDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());
        task.setId(taskViewModel.getId());

        //assertEquals(taskViewModel1, taskViewModel);
        taskerDao.updateTask(task);
        verify(taskerDao, atLeast(1)).updateTask(task);
    }


    private void setUpTaskerDaoMock(){
        taskerDao = mock(TaskerDaoJdbcTemplateImpl.class);
        Task task = new Task();

        task.setId(1);
        task.setDescription("Do the homework");
        task.setCreateDate(LocalDate.of(2019,7,1));
        task.setDueDate(LocalDate.of(2019,7,9));
        task.setCategory("School");

        Task task1 = new Task();
        task1.setDescription("Do the homework");
        task1.setCreateDate(LocalDate.of(2019,7,1));
        task1.setDueDate(LocalDate.of(2019,7,9));
        task1.setCategory("School");

        List<Task> taskList = new ArrayList<>();
        taskList.add(task);

        doReturn(task).when(taskerDao).createTask(task1);
        doReturn(task).when(taskerDao).getTask(1);
        doReturn(taskList).when(taskerDao).getAllTasks();
        doReturn(taskList).when(taskerDao).getTasksByCategory("School");
        //doReturn(task).when(taskerDao).updateTask(task1);

    }
}
