package com.saitej.springdatajpamappings.entity;



import lombok.*;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
//@ToString(exclude = "course")
@Entity
public class CourseMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseMaterialId;
    private String url;
     @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,optional = false)//optional false means we should not allow to create course without course material
     @JoinColumn(name = "course_id",referencedColumnName = "courseId")
    private Course course;


}
