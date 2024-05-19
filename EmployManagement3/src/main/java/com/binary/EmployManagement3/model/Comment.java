package com.binary.EmployManagement3.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Comment {
    private Integer id;
    private String givenMessage;
    private String messageWriterName;
    private Integer employeeId;
}
