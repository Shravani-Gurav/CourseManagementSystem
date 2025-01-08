package com.example.CourseManagementSystem.service;

import com.example.CourseManagementSystem.dto.CourseDto;
import com.example.CourseManagementSystem.entity.Course;
import com.example.CourseManagementSystem.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepo courseRepo;

            public Course createCourse(CourseDto courseDto){
                Course course=new Course();

                course.setTitle(courseDto.getTitle());
                course.setDescription(courseDto.getDescription());
                course.setCategory(courseDto.getCategory());

                return courseRepo.save(course);

            }

    public List<Course> getAllCourse() {
            return courseRepo.findAll();
    }

    public void deleteCourse(Long id) {
            courseRepo.deleteById(id);
    }

    public Course updateCourse(Long id, CourseDto courseDto) {
        Optional<Course> optionalCourse = courseRepo.findById(id);
        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();

            course.setTitle(courseDto.getTitle());
            course.setDescription(courseDto.getDescription());
            course.setCategory(courseDto.getCategory());

            return courseRepo.save(course);
        } else {
            throw new RuntimeException("Course with id " + id + " not found.");
        }
    }
}
