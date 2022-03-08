package com.example.ciscoTask.controller;

import com.example.ciscoTask.model.CaseTicket;
import com.example.ciscoTask.service.CaseTicketService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/caseTicket")
public class CaseTicketController {
    CaseTicketService caseTicketService;

    public CaseTicketController(CaseTicketService caseTicketService){
        this.caseTicketService = caseTicketService;
    }

    //The function receives a GET request, processes it and gives back a list of CaseTickets as a response.
    @GetMapping
    public ResponseEntity<List<CaseTicket>> getAllCaseTickets() {
        List<CaseTicket> caseTickets = caseTicketService.getCaseTickets();
        return new ResponseEntity<>(caseTickets, HttpStatus.OK);
    }

    //The function receives a GET request, processes it, and gives back a list of CaseTickets as a response.
    @GetMapping({"/{caseTicketId}"})
    public ResponseEntity<CaseTicket> getCaseTicket(@PathVariable Long caseTicketId) {
        return new ResponseEntity<>(caseTicketService.getCaseTicketById(caseTicketId), HttpStatus.OK);
    }

    //The function receives a POST request, processes it, creates a new CaseTicket and saves it to the database, and returns a resource link to the created CaseTicket.
    @PostMapping({"/post"})
    public ResponseEntity<CaseTicket> caseTicket(@RequestBody CaseTicket caseTicket) {
        CaseTicket caseTicket1 = caseTicketService.insert(caseTicket);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("caseTicket", "/api/v1/caseTicket/" + caseTicket1.getId().toString());
        return new ResponseEntity<>(caseTicket1, httpHeaders, HttpStatus.CREATED);
    }

    //The function receives a PUT request, updates the CaseTicket with the specified Id and returns the updated CaseTicket
    @PutMapping({"/{caseTicketId}"})
    public ResponseEntity<CaseTicket> updateCaseTicket(@PathVariable("caseTicketId") Long caseTicketId, @RequestBody CaseTicket caseTicket) {
        caseTicketService.uptadeCaseTicket(caseTicketId, caseTicket);
        return new ResponseEntity<>(caseTicketService.getCaseTicketById(caseTicketId), HttpStatus.OK);
    }

    //The function receives a DELETE request, deletes the CaseTicket with the specified Id.
    @DeleteMapping({"/{caseTicketId}"})
    public ResponseEntity<CaseTicket> deleteTodo(@PathVariable("caseTicketId") Long caseTicketId) {
        caseTicketService.deleteCaseTicket(caseTicketId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
