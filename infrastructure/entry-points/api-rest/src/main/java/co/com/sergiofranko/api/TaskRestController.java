package co.com.sergiofranko.api;
import co.com.sergiofranko.model.task.Task;
import co.com.sergiofranko.usecase.tasks.TaskUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class TaskRestController {
    private final TaskUseCase taskUseCase;


    @GetMapping
    public ResponseEntity<Map<String, Object>> getAll() {
        Map<String, Object> result = taskUseCase.getAll();
        if (!result.isEmpty()) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> save(@RequestBody Task task) {
        Map<String, Object> result = taskUseCase.save(task);
        if (!result.isEmpty()) {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
