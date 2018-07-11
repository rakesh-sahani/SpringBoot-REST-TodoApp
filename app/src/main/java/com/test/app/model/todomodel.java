package com.test.app.model;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "todo")
public class todomodel {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer taskId;
    private String taskName;
    private Boolean isDone = false;
    private Date createdAt;
    private java.sql.Date doneAt;

    public  todomodel(){super();}

    public  todomodel(Integer tasId,String tasName,Boolean Done,Date createAt,java.sql.Date dos)
    {
        super();
        this.taskId = tasId;
        this.taskName = tasName;
        this.isDone = Done;
        this.createdAt = createAt;
        this.doneAt = dos;
    }


    public java.sql.Date getDoneAt() {
        return doneAt;
    }

    public void setDoneAt(java.sql.Date doneAt) {
        this.doneAt = doneAt;
    }





    public Date getCreatedAt() {
        return createdAt;
    }

    public Date setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return createdAt;
    }


    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }



    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }



}
