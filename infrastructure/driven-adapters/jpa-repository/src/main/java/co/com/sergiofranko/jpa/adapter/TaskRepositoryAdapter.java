package co.com.sergiofranko.jpa.adapter;

import co.com.sergiofranko.jpa.entity.TaskEntity;
import co.com.sergiofranko.jpa.service.TaskService;
import co.com.sergiofranko.model.task.Task;
import co.com.sergiofranko.model.task.gateways.TaskGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class TaskRepositoryAdapter implements TaskGateway {

    @Autowired
    private TaskService taskService;

    @Override
    public List<Task> getAll() {
        List<Task> tasks = new ArrayList<>();
        Iterable<TaskEntity> taskEntities = taskService.getAll();

        if (taskEntities != null) {
            tasks = StreamSupport.stream(taskEntities.spliterator(), false)
                    .map(taskEntity -> {
                        return new Task(taskEntity.getId(),
                                taskEntity.getTitle(),
                                taskEntity.getDescription(),
                                taskEntity.getExecutionDate(),
                                taskEntity.getIdEmployee(),
                                taskEntity.getStatus());
                    })
                    .collect(Collectors.toList());
        }
        return tasks;
    }

    @Override
    public Task save(Task task) {
        TaskEntity taskEntity = new TaskEntity();
        BeanUtils.copyProperties(task, taskEntity);
        TaskEntity taskEntityResponse = taskService.save(taskEntity);
        if (taskEntityResponse != null) {
            BeanUtils.copyProperties(taskEntityResponse, task);
        }
        return task;
    }

    @Override
    public Task update(Task task) {
        TaskEntity taskEntity = new TaskEntity();
        if (taskService.getById(task.getId()).isEmpty()) {
            return null;
        }
        BeanUtils.copyProperties(task, taskEntity);
        TaskEntity taskEntityResponse = taskService.update(taskEntity);
        if (taskEntityResponse != null) {
            BeanUtils.copyProperties(taskEntityResponse, task);
        }
        return task;
    }

    @Override
    public boolean delete(long id) {
        return taskService.delete(id);
    }
}
