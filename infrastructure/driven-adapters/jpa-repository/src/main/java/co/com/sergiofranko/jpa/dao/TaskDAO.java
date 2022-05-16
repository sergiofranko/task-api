package co.com.sergiofranko.jpa.dao;

import co.com.sergiofranko.jpa.entity.TaskEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDAO extends CrudRepository<TaskEntity, Long> {
}
