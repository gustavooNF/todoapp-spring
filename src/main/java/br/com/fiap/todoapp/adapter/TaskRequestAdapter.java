package br.com.fiap.todoapp.adapter;

import br.com.fiap.todoapp.entity.Task;
import br.com.fiap.todoapp.request.TaskRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class TaskRequestAdapter implements IDefaultAdapter<TaskRequest, Task>{

	@Override
	public Task adapt(TaskRequest req) {
		return Task.builder().
			 idTask(generateId()).
			 nameTask(req.getNameTask()).
			 descriptionTask(req.getDescriptionTask()).
			 dateTask(LocalDateTime.parse(req.getDateTask() + " " + req.getHourTask(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))).build();
	}

	private static String generateId() {
		LocalDateTime now = LocalDateTime.now();
		StringBuilder id = new StringBuilder();
		id.append(now.getYear());
		id.append(now.getMonthValue());
		id.append(now.getDayOfMonth());
		id.append(now.getSecond());
		return id.toString();
	}
}
