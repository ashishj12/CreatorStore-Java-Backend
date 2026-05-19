package com.example.creatorstore.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemRequest {
	@NotNull(message = "product id is required")
	private Long productId;
	@NotNull(message = "quantity is required")
	@Min(value = 1, message = "quantity is must be atleast 1")
	private Integer quantity;
}
