package com.manyToMany.bidirectional.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manyToMany.bidirectional.dto.CourseDto;
import com.manyToMany.bidirectional.entity.Course;
import com.manyToMany.bidirectional.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@PostMapping("/saveCourseWithUser")
	public void saveCourseWithUser(@RequestBody CourseDto courseDto) {
		
		courseService.saveCourseWithUser(courseDto);
	}
	
	@GetMapping("/getCourse/{courseId}")
	public Course getCourse(@PathVariable int courseId) throws Exception {
		return courseService.getCourse(courseId);
	}
	
	@PostMapping("/assignCourseToUser/{userId}/{courseId}")
	public void assignCourseToUser(@PathVariable int userId, @PathVariable int courseId) throws Exception {
		
		courseService.assignCourseToUser(userId, courseId);
	}
}
