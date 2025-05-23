package com.springboot.demoposs.repo;

import com.springboot.demoposs.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories

public interface ItemRepo extends JpaRepository<Item, Integer> {
    List<Item> findAllByItemNameEquals(String itemName);

    List<Item> findAllByActiveStateEquals(boolean activeState);

    Page<Item> findAllByActiveStateEquals(boolean activeState, Pageable pageable);
    int countAllByActiveStateEquals(boolean activeState);


    Page<Item> findAllBy(Pageable pageable);

}
