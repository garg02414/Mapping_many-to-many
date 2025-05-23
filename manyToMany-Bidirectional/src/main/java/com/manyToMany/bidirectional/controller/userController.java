package com.manyToMany.bidirectional.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manyToMany.bidirectional.dto.CourseDto;
import com.manyToMany.bidirectional.dto.UserDto;
import com.manyToMany.bidirectional.entity.User;
import com.manyToMany.bidirectional.service.UserService;


@RestController
public class userController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/saveUserWithCourse")
	public void  saveUser(@RequestBody UserDto userDto) {

		userService.saveUser(userDto);
	}
	
	@PostMapping("/saveUser")
	public void saveOnlyUser(@RequestBody UserDto userDto) {
		
		userService.saveOnlyUser(userDto);
	}
	
	@PostMapping("/assignCourseTouser/{userId}")
	public void assignCourseTouser(@RequestBody CourseDto courseDto,@PathVariable int userId) throws Exception {
		
		userService.assignCourseTouser(courseDto, userId);
	}
	
	//assign existing course to existing user
	@PostMapping("/asignCourseToUser/{userId}/{courseId}")
	public void asignCourseToUser(@PathVariable int userId, @PathVariable int courseId ) throws Exception {
		
		userService.asignCourseToUser(userId, courseId);
	}
	
	@GetMapping("/getUser/{userId}")
	public User getUser(@PathVariable int userId) throws Exception {
		
		return userService.getUser(userId);
	}
	
	
}


































