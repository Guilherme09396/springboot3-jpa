package com.guilherme.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilherme.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
