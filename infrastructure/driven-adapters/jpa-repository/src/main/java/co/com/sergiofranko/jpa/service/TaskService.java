package co.com.sergiofranko.jpa.service;

import co.com.sergiofranko.jpa.dao.TaskDAO;
import co.com.sergiofranko.jpa.entity.TaskEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class TaskService {

    @Autowired
    private TaskDAO taskDAO;

    public Iterable<TaskEntity> getAll() {
        return taskDAO.findAll();
    }

    public TaskEntity save(TaskEntity taskEntity) {
        return taskDAO.save(taskEntity);
    }
}
