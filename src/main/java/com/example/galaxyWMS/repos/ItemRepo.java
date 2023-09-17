package com.example.galaxyWMS.repos;

import com.example.galaxyWMS.domain.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepo extends CrudRepository<Item, Long> {
    List<Item> findByName(String name);

    List<Item> findByNameLike(String name);

    Item findFirstByName(String name);

    List<Item> findAll();
}
