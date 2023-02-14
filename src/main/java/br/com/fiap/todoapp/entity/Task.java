package br.com.fiap.todoapp.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@ToString
@Table(name = "tb_task")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task implements Adaptable{

	@Id
	@Column(name = "ID_TASK")
	private String idTask;
	
	@Column(name = "NAME_TASK")
	private String nameTask;
	
	@Column(name = "DESCRIPTION_TASK")
	private String descriptionTask;
	
	@Column(name = "DATE_TASK")
	private LocalDateTime dateTask;
}
