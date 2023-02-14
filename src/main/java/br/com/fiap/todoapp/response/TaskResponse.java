package br.com.fiap.todoapp.response;

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
public class TaskResponse implements IRequest, Adaptable{
	
	public String idTask;
	
	public String nameTask;

	public String descriptionTask;

	public String dateTask;
	
	public String hourTask;
	
}
