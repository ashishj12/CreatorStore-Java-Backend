package com.example.creatorstore.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.creatorstore.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
