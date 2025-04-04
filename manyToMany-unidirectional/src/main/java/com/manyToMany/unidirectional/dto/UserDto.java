package com.manyToMany.unidirectional.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {

	private String userName;
	
	private List<CourseDto> courses;
}
