
package com.task;

import java.util.Optional;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path="/task") // This means URL's start with /demo (after Application path)
public class MainController {
  @Autowired // This means to get the bean called TaskRepository
         // Which is auto-generated by Spring, we will use it to handle the data
  private TaskRepository TaskRepository;

  @PostMapping(path="/") // Map ONLY POST Requests
  public @ResponseBody String add (
		  @RequestParam String dueDate,
		  @RequestParam String finishedDate,
		  @RequestParam String diffDays,
		  @RequestParam int number) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    Task t = new Task();
    t.setDiffDays(diffDays);
    t.setDueDate(dueDate);
    t.setFinishedDate(finishedDate);
    t.setNumber(number);
    TaskRepository.save(t);
    return "Saved";
  }

  @GetMapping(path="/")
  public @ResponseBody Iterable<Task> getAllTasks() {
    // This returns a JSON or XML with the Tasks
    return TaskRepository.findAll();
  }
  
  @GetMapping(path="/{id}")
  public @ResponseBody Optional<Task> getAllTasks(Long id) {
    // This returns a JSON or XML with the Tasks
    return TaskRepository.findById(id);
  }
  
  @DeleteMapping(path="/{id}")
  public @ResponseBody String delete (Long id) {
	TaskRepository.deleteById(id);
    return "Deleted";	  
  }
 
  
  @PutMapping(path="/{id}")
  public @ResponseBody String update(
	  @RequestParam Long id,
	  @RequestParam String dueDate,
	  @RequestParam String finishedDate,
	  @RequestParam String diffDays,
	  @RequestParam int number
  ) {

	  if (TaskRepository.findById(id).isPresent()) {
		  Task existTask = TaskRepository.findById(id).get();
		  existTask.setDiffDays(diffDays);
		  existTask.setDueDate(dueDate);
		  existTask.setFinishedDate(finishedDate);
		  existTask.setNumber(number);
		  TaskRepository.save(existTask);
		  return "Updated";
	  } else {
		  return "Theres no exist a item whith this id...";
	  }
  }

}