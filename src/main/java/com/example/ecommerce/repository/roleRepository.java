package com.example.ecommerce.repository;

import com.example.ecommerce.models.role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface roleRepository extends JpaRepository<role,Integer> {

}
