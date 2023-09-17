package com.example.galaxyWMS.repos;

import com.example.galaxyWMS.domain.DeliveryNote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryNoteRepo extends CrudRepository<DeliveryNote, Long> {
    DeliveryNote findByNumber(Long number);
    Long getIdByNumber(Long number);

}
