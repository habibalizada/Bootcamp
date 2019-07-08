package com.trilogyed.tasker.controller;

import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.service.TaskerServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RefreshScope
public class TaskerController {

    @Autowired
    TaskerServiceLayer service;

    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public TaskViewModel createTask(@RequestBody TaskViewModel taskViewModel){

        return service.newTask(taskViewModel);
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public TaskViewModel getTask(@PathVariable int id){
        if (id < 1) {
            throw new IllegalArgumentException("Id must be greater than 0.");
        }
        return service.fetchTask(id);
    }


    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TaskViewModel> getAllTasks(){
        return service.fetchAllTasks();
    }

    @RequestMapping(value = "/tasks/category/{category}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TaskViewModel> getTasksByCategory(@PathVariable String category){
        return service.fetchTasksByCategory(category);
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateTaskViewModel(@RequestBody TaskViewModel taskViewModel, @PathVariable int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Task ID on path must be greater than 0.");
        }
        taskViewModel.setId(id);
        service.updateTask(taskViewModel);
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable int id) {
        service.deleteTask(id);
    }
}
