package co.com.sergiofranko.model.user.gateways;

import co.com.sergiofranko.model.user.User;

import java.util.List;

public interface UserGateway {
    List<User> getAll();
    User getById(long id);
    User save(User user);
    User update(User user);
    boolean delete(long id);
}
