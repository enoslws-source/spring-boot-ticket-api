package com.Incident.Incident.services;

import com.Incident.Incident.dao.TicketRepository;
import com.Incident.Incident.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketImplement implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public TicketImplement(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Optional<Ticket> findById(long id){
       return ticketRepository.findById(id);
    }

    @Override
    public List<Ticket> findAll(){
        return ticketRepository.findAll();
    }
    @Override
    public Ticket save(Ticket ticket){
        return ticketRepository.save(ticket);
    }
    @Override
    public Ticket update(long id, Ticket ticket){
    Ticket ticket1 = ticketRepository.findById(id).orElseThrow();
    ticket1.setTicketName(ticket.getTicketName());
    ticket1.setTicketDescription(ticket.getTicketDescription());

    return ticketRepository.save(ticket1);
    }

    @Override
    public void delete(long id){
        ticketRepository.deleteById(id);
    }
}
