package com.test.app.controller;


import com.test.app.model.todomodel;
import com.test.app.repository.todoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;


import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping(path="/TodoApp")

public class todocontroller {

    @Autowired
    private todoRepository todorepository;

    Date dd;
    //View All Todo Task
    @GetMapping(path="/all")
    @ResponseBody
    public Iterable<todomodel> getAllTask() {
        // This returns a JSON or XML with the users
        return todorepository.findAll();
    }

    @PostMapping(path="/add")
    @ResponseBody
    public  todomodel addTask(@RequestBody todomodel  tm)
    {
        //el tm = new todomodel();
        //tm.setTaskId(taskId);
        //tm.setTaskName(taskName);

        tm.setCreatedAt(new Date());
        dd = tm.setCreatedAt(new Date());
        todorepository.save(tm);
        return tm;
    }
    // View By Task ID
    @GetMapping(path="/view/{taskId}")
    @ResponseBody
    public todomodel viewTask(@PathVariable Integer taskId)
    {
        Optional<todomodel> td = todorepository.findById(taskId);
        return td.get();
    }

    //Edit Todo Task
    @PostMapping(path="/edit/{taskId}")
    @ResponseBody
    public String editTask(@PathVariable  Integer taskId, @RequestParam String taskName, @RequestParam Boolean isDone, @RequestParam java.sql.Date  doneAt)
    {
        todomodel t = new todomodel();
        t.setTaskId(taskId);
        t.setTaskName(taskName);
        t.setCreatedAt(dd);
        System.out.print(dd);
        t.setDone(isDone);
        t.setDoneAt(doneAt);
        todorepository.save(t);
        return "Update";
    }

    //Delete By id
    @DeleteMapping(path="/delete/{taskId}")
    public String deleteTask(@PathVariable Integer taskId) {
       todorepository.deleteById(taskId);
       return "Delete";
    }

    @PostMapping("/test/{taskId}")
    @ResponseBody
    public ResponseEntity<Object> updateStudent(@RequestBody todomodel to, @PathVariable Integer taskId) {

        Optional<todomodel> td = todorepository.findById(taskId);

        if (!td.isPresent())
            return ResponseEntity.notFound().build();

        to.setTaskId(taskId);

        todorepository.save(to);

        return ResponseEntity.noContent().build();
    }

}
