package com.example.ecommerce.repository;


import com.example.ecommerce.models.order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface orderRepository extends JpaRepository<order,Long> {
}
