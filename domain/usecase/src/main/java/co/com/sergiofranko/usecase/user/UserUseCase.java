package co.com.sergiofranko.usecase.user;

import co.com.sergiofranko.model.user.User;
import co.com.sergiofranko.model.user.gateways.UserGateway;
import co.com.sergiofranko.usecase.util.UtilUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class UserUseCase {
    private final UserGateway userGateway;

    public Map<String, Object> getAll() {
        List<User> users = userGateway.getAll();
        boolean ok = users != null && !users.isEmpty();

        return UtilUseCase.responseResult(ok ? 1 : 0,
                ok ? "Usuarios encontrados" : "Lista de usuarios vacia",
                users);
    }

    public Map<String, Object> getById(long id) {
        User user = userGateway.getById(id);
        boolean ok = user != null && user.getId() != 0;

        return UtilUseCase.responseResult(ok ? 1 : 0,
                ok ? "Usuario encontrado" : "Usuario no encontrado",
                user);
    }

    public Map<String, Object> save(User user) {
        User data = userGateway.save(user);
        boolean ok = data != null && data.getId() != 0;
        return UtilUseCase.responseResult(ok ? 1 : 0,
                ok ? "Usuario creado exitosamente" : "Usuario no pudo ser creado",
                data);
    }

    public Map<String, Object> update(User user) {
        User data = userGateway.update(user);
        boolean ok = data != null && data.getId() != 0;
        return UtilUseCase.responseResult(ok ? 1 : 0,
                ok ? "Usuario editado exitosamente" : "Usuario no pudo ser editado",
                data);
    }

    public Map<String, Object> delete (long id) {
        boolean isDeleted = userGateway.delete(id);
        return UtilUseCase.responseResult(isDeleted ? 1 : 0,
                isDeleted ? "Usuario eliminado exitosamente" : "Usuario no pudo ser eliminado",
                null);
    }
}
