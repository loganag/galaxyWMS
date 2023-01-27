package com.example.galaxyWMS.repos;

import com.example.galaxyWMS.domain.DeliveredItems;
import com.example.galaxyWMS.domain.DeliveryNote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveredItemsRepo extends CrudRepository<DeliveredItems, Long> {
    List<DeliveredItems> findByDeliveryNote(DeliveryNote deliveryNote);
}
