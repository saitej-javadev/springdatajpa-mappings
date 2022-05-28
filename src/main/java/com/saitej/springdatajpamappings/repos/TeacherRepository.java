package com.saitej.springdatajpamappings.repos;

import com.saitej.springdatajpamappings.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
