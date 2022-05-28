package com.saitej.springdatajpamappings.repos;

import com.saitej.springdatajpamappings.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {

    //findBy methods(should match with entity fields)
    Student findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String name);

    //JPQL (table name is Entity class)
    @Query("select s from Student s where s.emailId=?1")
    Student getStudentByEmailAddress(String emailAddress);

//    @Query(value = "select * from student_tbl as sd where sd.guardian_name=?1",nativeQuery = true)
//    Student getStudentByGuardianNameNQ(String guardianName);

    //Native named param
    @Query(value = "select * from student_tbl as sd where sd.guardian_name=:guardianName",nativeQuery = true)
    Student getStudentByGuardianNameNQ(@Param("guardianName") String guardianName);


    @Transactional
    @Modifying
    @Query(value = "update student_tbl set first_name =?1 where email_Id=?2",nativeQuery = true)
    int updateStudentNameByEmailId(String firstName,String emailId);
}
