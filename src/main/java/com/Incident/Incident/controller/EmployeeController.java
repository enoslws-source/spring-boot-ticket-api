package com.Incident.Incident.controller;

import com.Incident.Incident.entities.Employee;
import com.Incident.Incident.entities.Ticket;
import com.Incident.Incident.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public Optional<Employee> findById(@PathVariable long id){
        return employeeService.findById(id);
    }
    @GetMapping
    public List<Employee> findAll(){
        return employeeService.findAll();
    }
    @PostMapping
    public Employee save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }
    @PutMapping("/{id}")
    public Employee update(@PathVariable long id, @RequestBody Employee employee){
        return employeeService.update(id, employee);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        employeeService.delete(id);
    }
    @PostMapping("/{id}/ticket")
    public ResponseEntity<String> addTicket(@PathVariable long id, @RequestBody Ticket ticket){
        return employeeService.addTicket(id, ticket);
    }
}
