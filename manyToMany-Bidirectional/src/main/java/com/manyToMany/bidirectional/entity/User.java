package com.manyToMany.bidirectional.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "user-bi")
public class User {

	@Id
	@GeneratedValue
	private int userId;
	private String userName;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name = "user_course_bi",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "course_id")
			)
	@JsonIgnoreProperties("users")
	private List<Course> course;
	
	
}