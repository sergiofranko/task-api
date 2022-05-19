package co.com.sergiofranko.jpa.adapter;

import co.com.sergiofranko.jpa.entity.UserEntity;
import co.com.sergiofranko.jpa.service.UserService;
import co.com.sergiofranko.model.user.User;
import co.com.sergiofranko.model.user.gateways.UserGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class UserRepositoryAdapter implements UserGateway {

    @Autowired
    private UserService userService;

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        Iterable<UserEntity> userEntities = userService.getAll();

        if (userEntities != null) {
            users = StreamSupport.stream(userEntities.spliterator(), false)
                    .map(userEntity -> {
                        return new User(userEntity.getId(),
                                userEntity.getName());
                    })
                    .collect(Collectors.toList());
        }
        return users;
    }

    @Override
    public User getById(long id) {
        User user = new User();
        Optional<UserEntity> userEntity = userService.getById(id);

        if (userEntity != null) {
            BeanUtils.copyProperties(userEntity.get(), user);
        }
        return user;
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        UserEntity userEntityResponse = userService.save(userEntity);
        if (userEntityResponse != null) {
            BeanUtils.copyProperties(userEntityResponse, user);
        }
        return user;
    }

    @Override
    public User update(User user) {
        UserEntity userEntity = new UserEntity();
        if (userService.getById(user.getId()).isEmpty()) {
            return null;
        }
        BeanUtils.copyProperties(user, userEntity);
        UserEntity userEntityResponse = userService.update(userEntity);
        if (userEntityResponse != null) {
            BeanUtils.copyProperties(userEntityResponse, user);
        }
        return user;
    }

    @Override
    public boolean delete(long id) {
        return userService.delete(id);
    }
}
