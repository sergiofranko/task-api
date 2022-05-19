package co.com.sergiofranko.jpa.service;

import co.com.sergiofranko.jpa.dao.UserDAO;
import co.com.sergiofranko.jpa.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public Iterable<UserEntity> getAll() {
        return userDAO.findAll();
    }

    public Optional<UserEntity> getById(long id) {
        return userDAO.findById(id);
    }

    public UserEntity save(UserEntity userEntity) {
        return userDAO.save(userEntity);
    }

    public UserEntity update(UserEntity userEntity) {
        return userDAO.save(userEntity);
    }

    public boolean delete(long id) {
        try {
            userDAO.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
