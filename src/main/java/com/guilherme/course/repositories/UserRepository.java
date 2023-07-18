package com.guilherme.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilherme.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
