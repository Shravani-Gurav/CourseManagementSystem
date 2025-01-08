package com.example.CourseManagementSystem.controller;

import com.example.CourseManagementSystem.dto.CourseDto;
import com.example.CourseManagementSystem.entity.Course;
import com.example.CourseManagementSystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cms")
public class CourseController {
    @Autowired
    private CourseService courseService;

    //create API
    @PostMapping("/addCourse")
    public ResponseEntity<Course> createCourse(@RequestBody CourseDto courseDto){

        Course course =courseService.createCourse(courseDto);
        return ResponseEntity.ok(course);
    }

    //Get All Records
    @GetMapping("/getAllRecord")
    public ResponseEntity<List<Course>> getAllCourseRecord(){
        List<Course> list= courseService.getAllCourse();
        return ResponseEntity.ok(list);
    }

    //delete record by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

    // Update record by ID
    @PutMapping("/updateCourse/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody CourseDto courseDto) {
        Course updatedCourse = courseService.updateCourse(id, courseDto);
        return ResponseEntity.ok(updatedCourse);
    }



}
