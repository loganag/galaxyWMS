package com.example.galaxyWMS.repos;

import com.example.galaxyWMS.domain.Warehouse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepo extends CrudRepository<Warehouse, Long> {
    Warehouse findByName(String name);
}
