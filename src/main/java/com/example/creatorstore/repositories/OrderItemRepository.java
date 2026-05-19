package com.example.creatorstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.creatorstore.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
