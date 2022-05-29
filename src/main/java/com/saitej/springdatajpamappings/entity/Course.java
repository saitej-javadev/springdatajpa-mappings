package com.saitej.springdatajpamappings.entity;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity

public class Course {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long courseId;
    private String title;
    private Integer credit;
    @OneToOne(mappedBy = "course")
    private CourseMaterial courseMaterial;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id",referencedColumnName = "teacherId")
    private Teacher teacher;


    @ManyToMany(cascade =  CascadeType.ALL)
    @JoinTable(name = "student_course",
    joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "courseId"),
    inverseJoinColumns = @JoinColumn(name = "student_id",referencedColumnName = "studentId"))
    private List<Student> students;


    public void addStudents(Student student){
        if (students==null) {
            students = new ArrayList<>();
            students.add(student);
        }
    }







    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", title='" + title + '\'' +
                ", credit=" + credit +
                '}';
    }
}


