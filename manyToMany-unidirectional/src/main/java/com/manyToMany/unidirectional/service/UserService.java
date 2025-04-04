package com.manyToMany.unidirectional.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manyToMany.unidirectional.dto.CourseDto;
import com.manyToMany.unidirectional.dto.UserDto;
import com.manyToMany.unidirectional.entity.Course;
import com.manyToMany.unidirectional.entity.User;
import com.manyToMany.unidirectional.repo.CourseRepository;
import com.manyToMany.unidirectional.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CourseRepository courseRepository;

	public void saveUser(UserDto userDto) {
	
		User user = new User();
		user.setUserName(userDto.getUserName());
		
		List<Course> courses = userDto.getCourses().stream().map(oneCourse -> convertDtoToEntity(oneCourse)).collect(Collectors.toList());
		
		user.setCourse(courses);
		userRepository.save(user);
	}

	private Course convertDtoToEntity(CourseDto oneCourse) {
		
		Course course = new Course();
		course.setCourseName(oneCourse.getCourseName());

		return course;
	}

	public void assignCourseTouser(CourseDto courseDto, int userId) throws Exception {
		
		User user = userRepository.findById(userId).orElseThrow(()-> new Exception("user not found "+ userId));
		
		Course course = new  Course();
		course.setCourseName(courseDto.getCourseName());
		
		user.getCourse().add(course);
		
		userRepository.save(user);
	}

	public void saveOnlyUser(UserDto userDto) {
		User user = new User();
		user.setUserName(userDto.getUserName());
		
		userRepository.save(user);
		
	}

	public void asignCourseToUser(int userId, int courseId) throws Exception {
		
		User user = userRepository.findById(userId).orElseThrow(()-> new Exception("user not found "+ userId));
		
		Course course = courseRepository.findById(courseId).orElseThrow(()-> new Exception("course not found "+ courseId));
		
		user.getCourse().add(course);
		userRepository.save(user);
	}

	public User getUser(int userId) throws Exception {
		
		return userRepository.findById(userId).orElseThrow(()-> new Exception("user not found "+ userId));
		
	}
	
	
	
}








