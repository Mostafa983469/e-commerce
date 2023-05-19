package com.example.ecommerce.repository;

import com.example.ecommerce.models.cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface cartRepository extends JpaRepository<cart,Long> {
}
