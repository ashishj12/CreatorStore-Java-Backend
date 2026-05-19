package com.example.creatorstore.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.creatorstore.dto.OrderRequest;
import com.example.creatorstore.entities.Order;
import com.example.creatorstore.services.OrderService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;

	@PostMapping
	public Order createOrder(@Valid @RequestBody OrderRequest orderRequest) {
		return orderService.createOrder(orderRequest);
	}

	// get all orders
	public List<Order> getAllOrders() {
		return null;
	}

	// get order by id
	public Order getOrderById() {
		return null;
	}

}
