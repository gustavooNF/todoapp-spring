package br.com.fiap.todoapp.service;

import br.com.fiap.todoapp.adapter.TaskRequestAdapter;
import br.com.fiap.todoapp.adapter.TaskResponseAdapter;
import br.com.fiap.todoapp.entity.Task;
import br.com.fiap.todoapp.repository.TaskRepository;
import br.com.fiap.todoapp.request.TaskRequest;
import br.com.fiap.todoapp.response.TaskResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TaskService {
	
	private static final Logger logger = LoggerFactory.getLogger(TaskService.class);
	
	private final TaskResponseAdapter response;
	
	private final TaskRequestAdapter request;
	
	private final TaskRepository repository;
	
	public TaskService(TaskResponseAdapter taskAdapter, TaskRequestAdapter taskReqAdapter, TaskRepository taskRepository) {
		this.response = taskAdapter;
		this.request = taskReqAdapter;
		this.repository = taskRepository;
	}
	
	public List<TaskResponse> findAll(){
		return response.adapt(repository.findAll());
	}
	
	public TaskResponse findById(String id){
	Task task = repository.findById(id).orElse(null);
		return response.adaptForTime(task);
	}
	
	public void save(TaskRequest req) {
		try {
			Task task = request.adapt(req);
			repository.save(task);
		} catch (Exception e) {
			logger.error("Erro ao salvar a tarefa.", e);
		}
	}
	
	public void update(TaskRequest req) {
		try {
			Task task = repository.findById(req.getIdTask()).orElse(null);
			if(task != null) {
			task.setNameTask(req.getNameTask());
			task.setDescriptionTask(req.getDescriptionTask());
			task.setDateTask(LocalDateTime.parse(req.getDateTask() + " " + req.getHourTask(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
			repository.save(task);
			}
		} catch (Exception e) {
			logger.error("Erro ao atualizar a tarefa.", e);
		}
		
	}
	
	public void delete(String id) {
		try {
		String idRefactor = id.replace("=", "");
			repository.deleteById(idRefactor);
		} catch (Exception e) {
			logger.error("Problemas ao excluir a tarefa.", e);
		}
	}
}
