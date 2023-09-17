package com.example.galaxyWMS.repos;

import com.example.galaxyWMS.domain.ReceivedItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceivedItemRepo extends CrudRepository<ReceivedItem, Long> {

}
