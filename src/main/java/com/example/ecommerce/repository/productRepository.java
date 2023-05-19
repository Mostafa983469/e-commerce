package com.example.ecommerce.repository;


import com.example.ecommerce.models.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepository extends JpaRepository<product,Long> {
}
