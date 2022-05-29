package com.saitej.springdatajpamappings.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long teacherId;
    private String firstName;
    private String secondName;
 /*   @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id",referencedColumnName = "teacherId")
    private List<Course> courses;*/
}
