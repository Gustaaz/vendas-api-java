package com.curso.java.vendasapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.java.vendasapi.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
