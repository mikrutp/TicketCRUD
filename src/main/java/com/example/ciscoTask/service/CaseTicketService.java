package com.example.ciscoTask.service;

import com.example.ciscoTask.model.CaseTicket;

import java.util.List;

public interface CaseTicketService {
    List<CaseTicket> getCaseTickets();

    CaseTicket getCaseTicketById(Long id);

    CaseTicket insert(CaseTicket caseTicket);

    void uptadeCaseTicket(Long id, CaseTicket caseTicket);

    void deleteCaseTicket(Long id);
}
