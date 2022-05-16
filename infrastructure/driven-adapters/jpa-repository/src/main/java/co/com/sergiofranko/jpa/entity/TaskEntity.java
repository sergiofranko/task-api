package co.com.sergiofranko.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Table(name = "task")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String title;

    @Column(length = 250, nullable = false)
    private String description;
    @Column(nullable = false)
    private Date executionDate;
    @Column(nullable = false)
    private int idEmployee;
    @Column(nullable = false)
    private String status;
}
