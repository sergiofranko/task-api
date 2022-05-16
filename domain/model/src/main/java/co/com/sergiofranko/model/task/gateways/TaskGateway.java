package co.com.sergiofranko.model.task.gateways;

import co.com.sergiofranko.model.task.Task;

import java.util.List;

public interface TaskGateway {
    List<Task> getAll();
    Task save(Task task);
}
