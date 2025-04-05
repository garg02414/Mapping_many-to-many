package com.manyToMany.bidirectional.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manyToMany.bidirectional.dto.CourseDto;
import com.manyToMany.bidirectional.dto.UserDto;
import com.manyToMany.bidirectional.entity.Course;
import com.manyToMany.bidirectional.entity.User;
import com.manyToMany.bidirectional.repo.CourseRepository;
import com.manyToMany.bidirectional.repo.UserRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private UserRepository userRepository;

	public void saveCourseWithUser(CourseDto courseDto) {
		
		Course course = new Course();
		
		course.setCourseName(courseDto.getCourseName());
		
		List<User> users = courseDto.getUsers().stream().map(oneUser -> convertDtoToEntity(oneUser,course)).collect(Collectors.toList());
		
		course.setUsers(users);
		
		courseRepository.save(course);
	}

	private User convertDtoToEntity(UserDto oneUser, Course course) {
		
		User user = new User();
		user.setUserName(oneUser.getUserName());
		user.setCourse(List.of(course));
		return user;
	}

	public Course getCourse(int courseId) throws Exception {
		return  courseRepository.findById(courseId).orElseThrow(()-> new Exception("course not found "+ courseId));
		
	}

	public void assignCourseToUser(int userId, int courseId) throws Exception {
	
		Course course = courseRepository.findById(courseId).orElseThrow(()-> new Exception("course not found "+ courseId));
		User user = userRepository.findById(userId).orElseThrow(()-> new Exception("user not found "+ userId));
		user.getCourse().add(course);
		
		course.getUsers().add(user);
		
		courseRepository.save(course);
	}
	
}
