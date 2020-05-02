package com.task.accessingdatamysql;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {

	//alterar para pelo que ira buscar	
    //List<Task> findById(int id);

}