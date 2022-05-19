package co.com.sergiofranko.usecase.tasks;

import co.com.sergiofranko.model.task.Task;
import co.com.sergiofranko.model.task.gateways.TaskGateway;
import co.com.sergiofranko.usecase.util.UtilUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class TaskUseCase {

    private final TaskGateway taskGateway;

    public Map<String, Object> getAll() {
        List<Task> tasks = taskGateway.getAll();
        boolean ok = tasks != null && !tasks.isEmpty();

        return UtilUseCase.responseResult(ok ? 1 : 0,
                ok ? "Tareas encontradas" : "Tareas no encontradas",
                tasks);
    }

    public Map<String, Object> save(Task task) {
        Task data = taskGateway.save(task);
        boolean ok = data != null && data.getId() != 0;
        return UtilUseCase.responseResult(ok ? 1 : 0,
                ok ? "Tarea creada exitosamente" : "Tarea no pudo ser creada",
                data);
    }

    public Map<String, Object> update(Task task) {
        Task data = taskGateway.update(task);
        boolean ok = data != null && data.getId() != 0;
        return UtilUseCase.responseResult(ok ? 1 : 0,
                ok ? "Tarea editada exitosamente" : "Tarea no pudo ser editada",
                data);
    }

    public Map<String, Object> delete (long id) {
        boolean isDeleted = taskGateway.delete(id);
        return UtilUseCase.responseResult(isDeleted ? 1 : 0,
                isDeleted ? "Tarea eliminada exitosamente" : "Tarea no pudo ser eliminada",
                null);
    }
}
