package com.Incident.Incident.services;

import com.Incident.Incident.entities.Employee;
import com.Incident.Incident.entities.Ticket;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {

    public Optional<Employee> findById(long id);
    public List<Employee> findAll();
    public Employee save(Employee employee);
    public Employee update(long id, Employee employee);
    public void delete(long id);
    public ResponseEntity<String> addTicket(long id, Ticket ticket);
}
