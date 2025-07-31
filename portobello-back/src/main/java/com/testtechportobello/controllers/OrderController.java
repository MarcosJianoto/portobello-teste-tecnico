package com.testtechportobello.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testtechportobello.dtos.OrderDTO;
import com.testtechportobello.services.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	

	private final OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	
	@PostMapping
	public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTO orderDTO) {
	    OrderDTO criado = orderService.createOrder(orderDTO);
	    return ResponseEntity.status(HttpStatus.CREATED).body(criado);
	}

	
	@GetMapping("{id}")
	public ResponseEntity<OrderDTO> getOrderById(@PathVariable String id) {
		OrderDTO orderDTO = orderService.getOrderById(id);
		return ResponseEntity.ok().body(orderDTO);
	}
	@GetMapping
	public ResponseEntity<List<OrderDTO>> getAllOrders() {
		List<OrderDTO> orderDTOs = orderService.getAllOrders();
		return ResponseEntity.ok().body(orderDTOs);
	}


}
