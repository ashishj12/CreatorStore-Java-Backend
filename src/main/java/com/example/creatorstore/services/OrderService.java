package com.example.creatorstore.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.creatorstore.dto.OrderItemRequest;
import com.example.creatorstore.dto.OrderRequest;
import com.example.creatorstore.entities.Order;
import com.example.creatorstore.entities.OrderItem;
import com.example.creatorstore.entities.Product;
import com.example.creatorstore.repositories.OrderRepository;
import com.example.creatorstore.repositories.ProductRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
	private final OrderRepository orderRepository;
	private final ProductRepository productRepository;

	@Transactional
	public Order createOrder(OrderRequest orderRequest) {

		List<OrderItem> orderItems = new ArrayList<>();
		BigDecimal totalPrice = BigDecimal.ZERO;

		Order order = new Order();
		order.setCustomerName(orderRequest.getCustomerName());
		order.setCustomerEmail(orderRequest.getCustomerEmail());
		order.setStatus("CONFIRMED");

		for (OrderItemRequest itemRequest : orderRequest.getItems()) {
			Product product = productRepository.findById(itemRequest.getProductId())
					.orElseThrow(() -> new RuntimeException("Product not found with id" + itemRequest.getProductId()));

			// check the stock quantity
			if (product.getStockQuantity() < itemRequest.getQuantity()) {
				throw new RuntimeException("Not enough stock " + itemRequest);
			}

			// calculate total price
			BigDecimal priceOfItem = product.getPrice().multiply(BigDecimal.valueOf(itemRequest.getQuantity()));

			totalPrice = totalPrice.add(priceOfItem);

			// update the product table with latest stock quantity
			product.setStockQuantity(product.getStockQuantity() - itemRequest.getQuantity());

			productRepository.save(product);

			// builder pattern to make object
			OrderItem orderItem = OrderItem.builder().order(order).product(product).quantity(itemRequest.getQuantity())
					.priceAtPurchase(product.getPrice()).build();
			orderItems.add(orderItem);
		}
		
		order.setTotalPrice(totalPrice);
		order.setOrderItems(orderItems);
		return orderRepository.save(order);
	}

}
