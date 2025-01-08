package com.example.CourseManagementSystem.repository;

import com.example.CourseManagementSystem.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course , Long> {
}
