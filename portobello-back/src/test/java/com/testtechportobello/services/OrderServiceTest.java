package com.testtechportobello.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import com.testtechportobello.dtos.OrderDTO;
import com.testtechportobello.entities.Customer;
import com.testtechportobello.entities.Item;
import com.testtechportobello.entities.Order;
import com.testtechportobello.mensageria.MensageriaService;
import com.testtechportobello.repositories.OrderRepository;

class OrderServiceTest {

    private OrderRepository orderRepository;
    private OrderService orderService;
    private MensageriaService mensageriaService;
    private SequenceGeneratorService sequenceGeneratorService;

    @BeforeEach
    void setUp() {
        orderRepository = mock(OrderRepository.class);
        mensageriaService = mock(MensageriaService.class);
        sequenceGeneratorService = mock(SequenceGeneratorService.class);
        orderService = new OrderService(orderRepository, mensageriaService, sequenceGeneratorService);
    }

    @Test
    void shouldCreateOrderSuccessfully() {

    	Item item = new Item();
        item.setUnityPrice(10.0);
        item.setQuantity(2);

        OrderDTO orderDTO = new OrderDTO();
        
        Customer customer = new Customer();
        customer.setName("Cliente X");
        customer.setEmail("email@teste.com");
        
        orderDTO.setCustomer(customer);
        orderDTO.setItems(List.of(item));

        orderService.createOrder(orderDTO);

        ArgumentCaptor<Order> captor = ArgumentCaptor.forClass(Order.class);
        verify(orderRepository, times(1)).save(captor.capture());

        Order savedOrder = captor.getValue();
        assertEquals("Cliente X", savedOrder.getCustomer().getName());
        assertEquals(20.0, savedOrder.getTotalValue());
        assertFalse(savedOrder.getItems().isEmpty());
        assertNotNull(savedOrder.getDate());
    }

    @Test
    void shouldThrowExceptionWhenItemsAreEmpty() {
        OrderDTO orderDTO = new OrderDTO();
        

        Customer customer = new Customer();
        customer.setName("Cliente X");
        customer.setEmail("email@teste.com");
        
        orderDTO.setCustomer(customer);
        orderDTO.setItems(List.of());

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            orderService.createOrder(orderDTO);
        });

        assertEquals("Itens estão nulos", ex.getMessage());
        verify(orderRepository, never()).save(any());
    }

    @Test
    void shouldReturnOrderById() {
        String orderId = "123";
        Order order = new Order();
        order.setId(orderId);
        
        Customer customer = new Customer();
        customer.setName("Cliente X");
        customer.setEmail("email@teste.com");
        
        order.setCustomer(customer);
        order.setDate(LocalDateTime.now());
        order.setItems(List.of());
        order.setTotalValue(99.9);

        when(orderRepository.findById(orderId)).thenReturn(Optional.of(order));

        OrderDTO result = orderService.getOrderById(orderId);

        assertEquals("Cliente X", result.getCustomer().getName());
        assertEquals(orderId, result.getId());
        assertEquals(99.9, result.getTotalValue());
    }

    @Test
    void shouldThrowExceptionIfOrderNotFound() {
        when(orderRepository.findById("nao-existe")).thenReturn(Optional.empty());

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            orderService.getOrderById("nao-existe");
        });

        assertEquals("Order not found", ex.getMessage());
    }

    @Test
    void shouldReturnAllOrders() {
    	
        Order order1 = new Order();
        order1.setId("1");

        Customer customer = new Customer();
        customer.setName("Cliente A");
        customer.setEmail("emailA@teste.com");

        order1.setCustomer(customer);
        order1.setDate(LocalDateTime.now());
        order1.setItems(List.of());
        order1.setTotalValue(50.0);

        Customer customerB = new Customer();
        customerB.setName("Cliente B");
        customerB.setEmail("emailB@teste.com");

        Order order2 = new Order();
        order2.setId("2");
        order2.setCustomer(customerB);
        order2.setDate(LocalDateTime.now());
        order2.setItems(List.of());
        order2.setTotalValue(70.0);

        when(orderRepository.findAll()).thenReturn(Arrays.asList(order1, order2));

        List<OrderDTO> result = orderService.getAllOrders();

        assertEquals(2, result.size());
        assertEquals("Cliente A", result.get(0).getCustomer().getName());
        assertEquals("Cliente B", result.get(1).getCustomer().getName());
    }

}
