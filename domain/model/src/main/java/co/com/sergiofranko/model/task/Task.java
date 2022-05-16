package co.com.sergiofranko.model.task;
import co.com.sergiofranko.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Task implements Serializable {
    private long id;
    private String title;
    private String description;
    private Date executionDate;
    private int idEmployee;
    private String status;
}
