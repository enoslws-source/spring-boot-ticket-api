package com.Incident.Incident.services;

import com.Incident.Incident.dao.EmployeeRepository;
import com.Incident.Incident.dao.TicketRepository;
import com.Incident.Incident.entities.Employee;
import com.Incident.Incident.entities.Status;
import com.Incident.Incident.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeImplement implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public EmployeeImplement(EmployeeRepository employeeRepository, TicketRepository ticketRepository){
        this.employeeRepository = employeeRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Optional<Employee> findById(long id){
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> findAll(){
       return employeeRepository.findAll();
    }

    @Override
    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(long id, Employee employee){
        Employee employee1 = employeeRepository.findById(id).orElseThrow();
        employee1.setFullName(employee.getFullName());
        employee1.setDepartment(employee.getDepartment());
        employee1.setTicket(employee.getTicket());

        return employeeRepository.save(employee1);
    }

    @Override
    public void delete(long id){
        employeeRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<String> addTicket(long id, Ticket ticket){
    Employee employee1 = employeeRepository.findById(id).orElseThrow();

    ticket = ticketRepository.findById(ticket.getId()).orElseThrow();
    ticket.setStatus(Status.ASSIGNED);
    ticketRepository.save(ticket);

    employee1.addTicket(ticket);
    employeeRepository.save(employee1);

    return ResponseEntity.status(HttpStatus.CREATED).body("Ticket added");
    }
}
