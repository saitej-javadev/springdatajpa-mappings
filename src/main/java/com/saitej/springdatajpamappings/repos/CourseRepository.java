package com.saitej.springdatajpamappings.repos;

import com.saitej.springdatajpamappings.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
