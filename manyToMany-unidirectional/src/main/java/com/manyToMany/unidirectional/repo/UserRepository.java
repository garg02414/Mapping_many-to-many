package com.manyToMany.unidirectional.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manyToMany.unidirectional.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	
}
