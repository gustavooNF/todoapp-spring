package br.com.fiap.todoapp.adapter;

import br.com.fiap.todoapp.entity.Task;
import br.com.fiap.todoapp.response.TaskResponse;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskResponseAdapter implements IDefaultAdapter<Task, TaskResponse> {
	
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	
	private DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm");
	
	@Override
	public TaskResponse adapt(Task input) {
		return TaskResponse.builder().
				idTask(input.getIdTask()).
				nameTask(input.getNameTask()).
				descriptionTask(input.getDescriptionTask()).
				dateTask(formatter.format(input.getDateTask())).build();
	}
	
	public TaskResponse adaptForTime(Task input) {
		return TaskResponse.builder().
				idTask(input.getIdTask()).
				nameTask(input.getNameTask()).
				descriptionTask(input.getDescriptionTask()).
				dateTask(formatterDate.format(input.getDateTask())).
				hourTask(formatterTime.format(input.getDateTask())).build();

	}
	
	public List<TaskResponse> adapt(List<Task> inputList){
		return inputList.stream().map(input -> adapt(input)).collect(Collectors.toList());
	}

}
