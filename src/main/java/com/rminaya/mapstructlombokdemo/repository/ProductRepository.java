package com.rminaya.mapstructlombokdemo.repository;

import com.rminaya.mapstructlombokdemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
