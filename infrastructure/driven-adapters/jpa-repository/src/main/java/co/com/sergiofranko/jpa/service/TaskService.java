package co.com.sergiofranko.jpa.service;

import co.com.sergiofranko.jpa.dao.TaskDAO;
import co.com.sergiofranko.jpa.entity.TaskEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


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

    public TaskEntity update (TaskEntity taskEntity) {
        return taskDAO.save(taskEntity);
    }

    public boolean delete(long id) {
        try {
            taskDAO.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Optional<TaskEntity> getById(long id) {
        return taskDAO.findById(id);
    }
}
