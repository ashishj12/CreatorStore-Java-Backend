package com.example.creatorstore.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class OrderRequest {
	@NotNull(message = "customer name is required")
	private String customerName;
	@NotNull(message = "customer email is required")
	@Email(message = "enter valid email")
	private String customerEmail;
	@Valid
	@NotEmpty(message = "Order must contain at least one item")
	private List<OrderItemRequest> items;
}
