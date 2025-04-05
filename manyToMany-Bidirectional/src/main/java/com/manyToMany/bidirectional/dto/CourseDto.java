package com.manyToMany.bidirectional.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CourseDto {

	private String courseName;	
	
	private List<UserDto> users;
}
