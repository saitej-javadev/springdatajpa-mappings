package com.saitej.springdatajpamappings.repos;

import com.saitej.springdatajpamappings.entity.Course;
import com.saitej.springdatajpamappings.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest {

@Autowired
private TeacherRepository teacherRepository;

@Test
    void testSaveTeacher() {
   Course course = Course.builder().title("Java").credit(5).build();
   Course course1 = Course.builder().title("Python").credit(5).build();
    List<Course> courses = Arrays.asList(course, course1);
    teacherRepository.save(Teacher.builder().firstName("Tony").secondName("Robbins").courses(courses).build());
        }
        }