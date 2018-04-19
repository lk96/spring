package com.inspur.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inspur.domain.Product;

public interface ProductDao extends JpaRepository<Product,Long> {
    public Optional<Product> findById(Long id);
}
