package com.saitej.springdatajpamappings.repos;

import com.saitej.springdatajpamappings.entity.Course;
import com.saitej.springdatajpamappings.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;


    @Test
    void testCourseMaterial() {
        Course course = Course.builder().title("Java").credit(4).build();
        CourseMaterial savedCourseMaterial = courseMaterialRepository.save(CourseMaterial.builder().url("www.facebook.com")
               . course(course)
                        .build());

        assertNotNull(savedCourseMaterial);
    }


    @Test
    void getAllCourseMaterials() {
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println(courseMaterials);
    }
}