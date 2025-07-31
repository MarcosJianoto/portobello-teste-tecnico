<<<<<<< HEAD
package com.testtechportobello.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testtechportobello.dtos.OrderDTO;
import com.testtechportobello.entities.Customer;
import com.testtechportobello.entities.Item;
import com.testtechportobello.services.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

public class OrderControllerTest {

    private MockMvc mockMvc;
    private OrderService orderService;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        orderService = Mockito.mock(OrderService.class);
        OrderController orderController = new OrderController(orderService);
        mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void shouldSaveOrder() throws Exception {
        OrderDTO orderDTO = new OrderDTO();
        Customer customer = new Customer();
        customer.setName("Cliente X");
        orderDTO.setCustomer(customer);
        orderDTO.setItems(List.of(new Item()));

        String json = objectMapper.writeValueAsString(orderDTO);

        mockMvc.perform(post("/order")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated());
    }

    @Test
    void shouldReturnOrderById() throws Exception {
        String id = "123";
        OrderDTO orderDTO = new OrderDTO();
        Customer customer = new Customer();
        customer.setName("Cliente X");
        orderDTO.setCustomer(customer);
        orderDTO.setId(id);

        when(orderService.getOrderById(id)).thenReturn(orderDTO);

        mockMvc.perform(get("/order/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.customer.name").value("Cliente X"));
    }

    @Test
    void shouldReturnAllOrders() throws Exception {
        OrderDTO order1 = new OrderDTO();
        order1.setId("1");
        Customer customer1 = new Customer();
        customer1.setName("Cliente A");
        order1.setCustomer(customer1);

        OrderDTO order2 = new OrderDTO();
        order2.setId("2");
        Customer customer2 = new Customer();
        customer2.setName("Cliente B");
        order2.setCustomer(customer2);

        when(orderService.getAllOrders()).thenReturn(List.of(order1, order2));

        mockMvc.perform(get("/order"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].customer.name").value("Cliente A"))
                .andExpect(jsonPath("$[1].customer.name").value("Cliente B"));
    }
}
=======
package com.testtechportobello.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testtechportobello.dtos.OrderDTO;
import com.testtechportobello.entities.Customer;
import com.testtechportobello.entities.Item;
import com.testtechportobello.services.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

public class OrderControllerTest {

    private MockMvc mockMvc;
    private OrderService orderService;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        orderService = Mockito.mock(OrderService.class);
        OrderController orderController = new OrderController(orderService);
        mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void shouldSaveOrder() throws Exception {
        OrderDTO orderDTO = new OrderDTO();
        Customer customer = new Customer();
        customer.setName("Cliente X");
        orderDTO.setCustomer(customer);
        orderDTO.setItems(List.of(new Item()));

        String json = objectMapper.writeValueAsString(orderDTO);

        mockMvc.perform(post("/order")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated());
    }

    @Test
    void shouldReturnOrderById() throws Exception {
        String id = "123";
        OrderDTO orderDTO = new OrderDTO();
        Customer customer = new Customer();
        customer.setName("Cliente X");
        orderDTO.setCustomer(customer);
        orderDTO.setId(id);

        when(orderService.getOrderById(id)).thenReturn(orderDTO);

        mockMvc.perform(get("/order/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.customer.name").value("Cliente X"));
    }

    @Test
    void shouldReturnAllOrders() throws Exception {
        OrderDTO order1 = new OrderDTO();
        order1.setId("1");
        Customer customer1 = new Customer();
        customer1.setName("Cliente A");
        order1.setCustomer(customer1);

        OrderDTO order2 = new OrderDTO();
        order2.setId("2");
        Customer customer2 = new Customer();
        customer2.setName("Cliente B");
        order2.setCustomer(customer2);

        when(orderService.getAllOrders()).thenReturn(List.of(order1, order2));

        mockMvc.perform(get("/order"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].customer.name").value("Cliente A"))
                .andExpect(jsonPath("$[1].customer.name").value("Cliente B"));
    }
}
>>>>>>> aeb2af5 (Corrige backend como pasta comum e não como submódulo)
