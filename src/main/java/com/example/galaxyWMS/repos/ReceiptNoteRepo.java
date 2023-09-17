package com.example.galaxyWMS.repos;

import com.example.galaxyWMS.domain.ReceiptNote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptNoteRepo extends CrudRepository<ReceiptNote, Long> {
    ReceiptNote findByNumber(String number);
}
