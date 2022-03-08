package com.example.ciscoTask.repository;


import com.example.ciscoTask.model.CaseTicket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseTicketRepo extends CrudRepository<CaseTicket, Long> {
}
