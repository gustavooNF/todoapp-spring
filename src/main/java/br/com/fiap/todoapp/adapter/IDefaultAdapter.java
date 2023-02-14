package br.com.fiap.todoapp.adapter;

import br.com.fiap.todoapp.entity.Adaptable;

public interface IDefaultAdapter <I extends Adaptable, O extends Adaptable> {
	
	O adapt (I input);

}
