package com.manyToMany.unidirectional.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "course-uni")
public class Course {

	@Id
	@GeneratedValue
	private int courseId;
	private String courseName;
}
