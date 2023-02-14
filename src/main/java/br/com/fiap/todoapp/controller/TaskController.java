package br.com.fiap.todoapp.controller;

import java.util.List;

import br.com.fiap.todoapp.request.TaskRequest;
import br.com.fiap.todoapp.response.TaskResponse;
import br.com.fiap.todoapp.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/to-do-app")
public class TaskController {
	
	private TaskService toDoAppService;
	
	public TaskController(TaskService toDoAppService) {
		this.toDoAppService = toDoAppService;
	}

	@GetMapping("/all-registers")
	public ResponseEntity<List<TaskResponse>> findAll(){
		return ResponseEntity.ok(toDoAppService.findAll());
	}
	

	@GetMapping("/by-id-registers/{taskId}")
	public ResponseEntity<TaskResponse> findbyId(@PathVariable String taskId){
		return ResponseEntity.ok(toDoAppService.findById(taskId));
	}
	
	@PostMapping("/save-task")
	public ResponseEntity<Void> saveTask(@RequestBody TaskRequest req) {
		toDoAppService.save(req);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/delete-task")
	public ResponseEntity<Void> deleteTask(@RequestBody String id) {
		toDoAppService.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/update-task")
	public ResponseEntity<Void> updateTask(@RequestBody TaskRequest req) {
		toDoAppService.update(req);
		return ResponseEntity.ok().build();
	}

}
