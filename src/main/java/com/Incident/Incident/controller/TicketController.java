package com.Incident.Incident.controller;


import com.Incident.Incident.entities.Ticket;
import com.Incident.Incident.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    @GetMapping("/{id}")
    public Optional<Ticket> findById(@PathVariable long id){
        return ticketService.findById(id);
    }

    @GetMapping
    public List<Ticket> findAll(){
        return ticketService.findAll();
    }

    @PostMapping("/{id}")
    public Ticket save(@RequestBody Ticket ticket){
        return ticketService.save(ticket);
    }
    @PutMapping("/{id}")
    public Ticket update(@PathVariable long id, @RequestBody Ticket ticket){
        return ticketService.update(id, ticket);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        ticketService.delete(id);
    }
}
