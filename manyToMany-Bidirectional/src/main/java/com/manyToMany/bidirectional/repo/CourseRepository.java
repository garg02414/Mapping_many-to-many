package com.manyToMany.bidirectional.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manyToMany.bidirectional.entity.Course;


public interface CourseRepository extends JpaRepository<Course, Integer>{

}
