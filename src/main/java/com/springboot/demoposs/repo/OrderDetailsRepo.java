package com.springboot.demoposs.repo;

import com.springboot.demoposs.entity.Item;
import com.springboot.demoposs.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories

public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Integer> {
}
