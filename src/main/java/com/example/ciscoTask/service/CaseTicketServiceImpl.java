package com.example.ciscoTask.service;

import com.example.ciscoTask.model.CaseTicket;
import com.example.ciscoTask.repository.CaseTicketRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaseTicketServiceImpl implements  CaseTicketService{
    CaseTicketRepo caseTicketRepo;

    public CaseTicketServiceImpl(CaseTicketRepo caseTicketRepo){
        this.caseTicketRepo = caseTicketRepo;
    }

    @Override
    public List<CaseTicket> getCaseTickets() {
        List<CaseTicket> caseTickets = new ArrayList<>();
        caseTicketRepo.findAll().forEach(caseTickets::add);
        return caseTickets;
    }

    @Override
    public CaseTicket getCaseTicketById(Long id) {
        return caseTicketRepo.findById(id).get();
    }

    @Override
    public CaseTicket insert(CaseTicket caseTicket) {
        return caseTicketRepo.save(caseTicket);
    }

    @Override
    public void uptadeCaseTicket(Long id, CaseTicket caseTicket) {
        CaseTicket caseTicketFromDb = caseTicketRepo.findById(id).get();
        System.out.println(caseTicketFromDb.toString());
        caseTicketFromDb.setTitle(caseTicket.getTitle());
        caseTicketFromDb.setDescription(caseTicket.getDescription());
        caseTicketFromDb.setSeverity(caseTicket.getSeverity());
        caseTicketFromDb.setStatus(caseTicket.getStatus());
        caseTicketRepo.save(caseTicketFromDb);
    }

    @Override
    public void deleteCaseTicket(Long id) {
        caseTicketRepo.deleteById(id);
    }
}
