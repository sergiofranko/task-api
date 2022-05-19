package co.com.sergiofranko.jpa.dao;

import co.com.sergiofranko.jpa.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends CrudRepository<UserEntity, Long> {
}
