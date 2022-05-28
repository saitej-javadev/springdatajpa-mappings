package com.saitej.springdatajpamappings.repos;

import com.saitej.springdatajpamappings.entity.Guardian;
import com.saitej.springdatajpamappings.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest

class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void testSaveStudent() {

        Student student = Student.builder().
                emailId("virat").firstName("virat").lastName("kohil").guardian(Guardian.builder().name("anushaka")
                .email("anushka@gmail.com").mobile("9999999999").build()).
                build();
        Student savedStudent = studentRepository.save(student);
        assertNotNull(savedStudent);
    }


    @Test
    void getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        assertEquals(2,studentList.size());

    }

    @Test
    void testMethodFindByFirstName() {
        Student student = studentRepository.findByFirstName("virat");
        assertEquals("virat",student.getFirstName());
    }


    @Test
    void testMethodFindByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("at");
        System.out.println(students);
        assertEquals(1,students.size());
    }

    @Test
    void testGetStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("virat@gmail.com");
        assertEquals("virat",student.getFirstName());
    }

    @Test
    void testGetStudentByGuardianNameNQ() {
        Student student = studentRepository.getStudentByGuardianNameNQ("anushka");
        System.out.println("student = " + student);
        assertEquals("anushka",student.getGuardian().getName());
    }

    @Test
    void testUpdateStudentNameByEmailId() {
        int num = studentRepository.updateStudentNameByEmailId("Chiku", "virat@gmail.com");
        assertNotNull(1);
    }
}