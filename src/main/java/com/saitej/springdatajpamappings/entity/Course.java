package com.saitej.springdatajpamappings.entity;


import lombok.*;

import javax.persistence.*;

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

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", title='" + title + '\'' +
                ", credit=" + credit +
                '}';
    }
}


