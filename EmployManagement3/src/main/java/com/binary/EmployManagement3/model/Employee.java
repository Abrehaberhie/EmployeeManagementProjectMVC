package com.binary.EmployManagement3.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor

@NoArgsConstructor
public class Employee {





    private Integer id;

    @NotNull(message = " name is required")
    @Size(min = 3, max = 50)
    private String name;
    @NotNull(message = "departement is required")
    @Size(min = 3, max = 50)
    private String department;
    @NotNull
    @Size(min =4, message = "The body should be at least 10 characters")
    @Size(max =60, message = "The body should not exceeded  100 characters")
    private String role;
    private List<Comment> comments;

}
