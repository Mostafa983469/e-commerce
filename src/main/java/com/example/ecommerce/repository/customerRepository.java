package com.example.ecommerce.repository;

import com.example.ecommerce.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface  customerRepository extends JpaRepository<Customer,Long> {

    @Query(value = "select *from Customer u where u.email=:email",nativeQuery = true)
    public Optional<List<Customer>> findByEmail(String email);

    @Query(value = "select *from Customer u where u.name=:name",nativeQuery = true)
    public List<Customer> findByName(String name);
    @Query(value = "select  *from Customer u where u.email=:email and u.password=:password",nativeQuery = true)
    public Optional<List<Customer>> login(String email, String password);
}
