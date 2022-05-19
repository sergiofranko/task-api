package co.com.sergiofranko.api;

import co.com.sergiofranko.model.user.User;
import co.com.sergiofranko.usecase.user.UserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class UserRestController {
    private final UserUseCase userUsecase;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAll() {
        Map<String, Object> result = userUsecase.getAll();

        if (!result.isEmpty()) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable long id) {
        Map<String, Object> result = userUsecase.getById(id);

        if (!result.isEmpty()) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> save(@RequestBody User user) {
        Map<String, Object> result = userUsecase.save(user);
        if (!result.isEmpty()) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping
    public  ResponseEntity<Map<String,Object>> update(@RequestBody User user) {
        Map<String, Object> result = userUsecase.update(user);
        if (!result.isEmpty()) {
            return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable long id){
        Map<String, Object> result = userUsecase.delete(id);
        if (!result.isEmpty()) {
            return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
