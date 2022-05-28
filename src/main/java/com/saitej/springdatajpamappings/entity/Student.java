package com.saitej.springdatajpamappings.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "student_tbl",uniqueConstraints = @UniqueConstraint(name = "emailId_unique",columnNames = "emailId"))
public class Student {

    @Id
    @SequenceGenerator(name = "student_sequence",sequenceName = "student_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_sequence")
    private Long studentId;
    private String firstName;
    private String lastName;
    @Column(name = "emailId",nullable = false)
    private String emailId;
    @Embedded
    private Guardian guardian;

}


