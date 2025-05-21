package com.springboot.demoposs.repo;

import com.springboot.demoposs.dto.queryinterface.OrderDetailsInterface;
import com.springboot.demoposs.dto.response.ResponseOrderDetailsDTO;
import com.springboot.demoposs.entity.Item;
import com.springboot.demoposs.entity.Order;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@EnableJpaRepositories

public interface OrderRepo extends JpaRepository<Order, Integer> {

    @Query(value = "select c.customer_name as customerName," +
            " c.customer_address as customerAddress," +
            " o.order_date as orderDate," +
            " o.total as total from customer c,orders o where o.active_state = ?1 and" +
            " c.customer_id = o.customer_id", nativeQuery = true )
    List<OrderDetailsInterface> getAllOrderDetails(boolean status, Pageable pageable);

    @Query(value = "select count(*) from customer c,orders o where o.active_state = ?1 and c.customer_id = o.customer_id" , nativeQuery = true )
    long countAllOrderDetails(boolean status);
}
