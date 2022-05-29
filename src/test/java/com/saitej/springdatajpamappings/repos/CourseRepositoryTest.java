package com.saitej.springdatajpamappings.repos;

import com.saitej.springdatajpamappings.entity.Course;
import com.saitej.springdatajpamappings.entity.Student;
import com.saitej.springdatajpamappings.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;


    @Test
    void testSaveCourseWithTeacher() {

      //  CourseMaterial courseMaterial =CourseMaterial.builder().url("www.springframework.com").build();
        Teacher teacher =Teacher.builder().firstName("Jay").secondName("Shetty").build();

        Course course = Course.builder().
                title("Spring Boot").credit(6).teacher(teacher).
                build();
        Course savedCourse = courseRepository.save(course);
        assertNotNull(savedCourse);

    }


    @Test
    void testFindAllPagination() {
        Pageable firstPagewithThreeRecords = PageRequest.of(0,3);
        Pageable secondPagewithThreeRecords = PageRequest.of(1,4);
       // List<Course> courses = courseRepository.findAll();
       // System.out.println(courses);

        List<Course> courses = courseRepository.findAll(secondPagewithThreeRecords).getContent();
        long totalElements = courseRepository.findAll(secondPagewithThreeRecords).getTotalElements();
        System.out.println("totalElements = " + totalElements);
        int totalPages = courseRepository.findAll(secondPagewithThreeRecords).getTotalPages();
        System.out.println("totalPages = " + totalPages);
        int numberOfElements = courseRepository.findAll(secondPagewithThreeRecords).getNumberOfElements();
        System.out.println("numberOfElements = " + numberOfElements);


    }

    @Test
    void testFindAllSorting() {
        Pageable sortByTitle = PageRequest.of(0,2, Sort.by("title"));
        Pageable sortByCreditDesc = PageRequest.of(1,2,Sort.by("credit").descending());

        List<Course> content = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("content = " + content);
        List<Course> content1 = courseRepository.findAll(sortByCreditDesc).getContent();
        System.out.println("content1 = " + content1);
    }


    @Test
    void saveCourseWithStudentAndTeacher() {
        Teacher teacher = Teacher.builder().firstName("Tony").secondName("Stark").build();
       Student student = Student.builder().firstName("saitej").lastName("galipelli").emailId("saitej@gmail.com").build();
        Course course = Course.builder().title("AI").credit(12).teacher(teacher).build();

        course.addStudents(student);

        courseRepository.save(course);
    }
}