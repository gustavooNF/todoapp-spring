package br.com.fiap.todoapp.request;

import br.com.fiap.todoapp.entity.Adaptable;
import br.com.fiap.todoapp.entity.IRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TaskRequest implements IRequest, Adaptable{
	
	private String idTask;
	
	private String nameTask;

	private String descriptionTask;

	private String dateTask;
	
	private String hourTask;
}
