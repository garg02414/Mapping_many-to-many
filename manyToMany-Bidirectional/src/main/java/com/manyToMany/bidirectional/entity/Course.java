package com.manyToMany.bidirectional.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "course-bi")
public class Course {

	@Id
	@GeneratedValue
	private int courseId;
	private String courseName;
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "course")
	@JsonIgnoreProperties("course")
	private List<User> users;
}
