package com.test.app.repository;


import com.test.app.model.todomodel;
import org.springframework.data.repository.CrudRepository;

public interface todoRepository extends CrudRepository<todomodel,Integer>{

}
