/*
package com.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}

}
*/

package com.task.accessingdatamysql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(TaskApplication.class);

    @Autowired
    private TaskRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class, args);
    }

    @Override
    public void run(String... args) {

        log.info("StartApplication...");
        repository.save(new Task(1, "123", "12-2-20", "13-2-20"));
        repository.save(new Task(2, "234", "12-2-22", "13-2-22"));
        repository.save(new Task(3, "345", "12-2-23", "13-2-23"));

        System.out.println("\nfindAll()");
        repository.findAll().forEach(x -> System.out.println(x));

        System.out.println("\nfindById(1L)");
        repository.findById(1l).ifPresent(x -> System.out.println(x));

        System.out.println("\nfindByName('Node')");
        //repository.findById(1).forEach(x -> System.out.println(x));

    }

}