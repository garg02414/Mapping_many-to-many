package com.manyToMany.bidirectional.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manyToMany.bidirectional.entity.User;


public interface UserRepository extends JpaRepository<User, Integer>{

	
}
