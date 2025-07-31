package com.testtechportobello.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.testtechportobello.dtos.OrderDTO;
import com.testtechportobello.entities.Item;
import com.testtechportobello.entities.Order;
import com.testtechportobello.mensageria.MensageriaService;
import com.testtechportobello.repositories.OrderRepository;

@Service
public class OrderService {

	private OrderRepository orderRepository;
	private MensageriaService mensageriaService;
	private SequenceGeneratorService sequenceGeneratorService;

	public OrderService(OrderRepository orderRepository, MensageriaService mensageriaService, SequenceGeneratorService sequenceGeneratorService) {
		this.orderRepository = orderRepository;
		this.mensageriaService = mensageriaService;
		this.sequenceGeneratorService = sequenceGeneratorService;
	}

	public OrderDTO createOrder(OrderDTO orderDTO) {
		
		System.out.println("Recebido no backend:");
	    orderDTO.getItems().forEach(item -> System.out.println("Produto: " + item.getProductName()));


	    if (orderDTO.getItems() == null || orderDTO.getItems().isEmpty()) {
	        throw new IllegalArgumentException("Itens estão nulos");
	    }

	    double totalValue = 0.0;
	    for (Item item : orderDTO.getItems()) {
	        totalValue += item.getUnityPrice() * item.getQuantity();
	    }

	    Order order = new Order();
	    order.setId(null); // 
	    order.setDate(LocalDateTime.now());
	    order.setOrderNumber(sequenceGeneratorService.generateSequence("order_sequence"));
	    order.setCustomer(orderDTO.getCustomer());
	    order.setItems(orderDTO.getItems());
	    order.setTotalValue(totalValue);

	    orderRepository.save(order);

	    mensageriaService.enviarMensagem("Novo pedido criado: ID = " + order.getId());

	    OrderDTO savedOrderDTO = new OrderDTO();
	    savedOrderDTO.setId(order.getId());
	    savedOrderDTO.setDate(order.getDate().toString());
	    savedOrderDTO.setOrderNumber(order.getOrderNumber());
	    savedOrderDTO.setCustomer(order.getCustomer());
	    savedOrderDTO.setItems(order.getItems());
	    savedOrderDTO.setTotalValue(order.getTotalValue());
	    

	    return savedOrderDTO;
	}



	public OrderDTO getOrderById(String id) {

		Order order = orderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Order not found"));
		
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setId(order.getId());
		orderDTO.setCustomer(order.getCustomer());
		orderDTO.setDate(order.getDate().toString());
		orderDTO.setOrderNumber(order.getOrderNumber());
		orderDTO.setItems(order.getItems());
		orderDTO.setTotalValue(order.getTotalValue());
		
		return orderDTO;

	}
	public List<OrderDTO> getAllOrders() {
		
		List<Order> order = orderRepository.findAll();
		List<OrderDTO> orderList = new ArrayList<>();
		
		for(Order ord: order) {
			
			OrderDTO orderDTO = new OrderDTO();
			orderDTO.setId(ord.getId());
			orderDTO.setCustomer(ord.getCustomer());
			orderDTO.setDate(ord.getDate().toString());
			orderDTO.setOrderNumber(ord.getOrderNumber());
			orderDTO.setItems(ord.getItems());
			orderDTO.setTotalValue(ord.getTotalValue());
			
			orderList.add(orderDTO);
			
		}
		
		return orderList;
	}

}
