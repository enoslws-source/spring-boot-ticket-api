package com.Incident.Incident.services;

import com.Incident.Incident.dao.TicketRepository;
import com.Incident.Incident.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public interface TicketService {

    public Optional<Ticket> findById(long id);
    public List<Ticket> findAll();
    public Ticket save(Ticket ticket);
    public Ticket update(long id, Ticket ticket);
    public void delete(long id);
}
