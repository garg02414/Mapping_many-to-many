package com.manyToMany.unidirectional.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manyToMany.unidirectional.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{

}
