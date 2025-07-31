<<<<<<< HEAD
package com.testtechportobello.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.testtechportobello.entities.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

}
=======
package com.testtechportobello.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.testtechportobello.entities.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

}
>>>>>>> aeb2af5 (Corrige backend como pasta comum e não como submódulo)
