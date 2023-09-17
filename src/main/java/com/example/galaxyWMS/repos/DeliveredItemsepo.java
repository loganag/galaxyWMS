package com.example.galaxyWMS.repos;

import com.example.galaxyWMS.domain.DeliveredItem;
import com.example.galaxyWMS.domain.DeliveryNote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveredItemsepo extends CrudRepository<DeliveredItem, Long> {
    List<DeliveredItem> findByDeliveryNote(DeliveryNote deliveryNote);
}
