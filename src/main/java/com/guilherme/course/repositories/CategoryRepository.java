package com.guilherme.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilherme.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
