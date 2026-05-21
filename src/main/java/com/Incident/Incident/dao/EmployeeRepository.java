package com.Incident.Incident.dao;

import com.Incident.Incident.entities.Employee;
import com.Incident.Incident.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
