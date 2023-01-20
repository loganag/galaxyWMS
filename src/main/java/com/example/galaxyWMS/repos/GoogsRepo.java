package com.example.galaxyWMS.repos;

import com.example.galaxyWMS.domain.Goods;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoogsRepo extends CrudRepository<Goods, Long> {
    List<Goods> findByName(String name);
}
