package br.com.fiap.todoapp.service;

import br.com.fiap.todoapp.entity.Task;
import br.com.fiap.todoapp.request.TaskRequest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

@SpringBootTest
public class TaskServiceTest {

    @Mock
    private TaskService taskService;

    private TaskRequest task;


    @Before
    public void init() {
        task = new TaskRequest("1", "Name Task Test", "Description Task Test", "01/02/2023", "10:00");
    }

    @Test
    public void deveCastrarUmaTask() {
    }

    @Test
    public void deveBuscarTasksPorId() {
    }

    @Test
    public void deveFazerUpdateDeTarefa(){
    }
   
}
