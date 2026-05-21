package com.Incident.Incident.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "department")
    private String department;

    @Column(name = "ticket")
    @OneToMany
    private List<Ticket> ticket; // one employee has many tickets so this is a collection instead of just a single ticket object.

    public Employee(){
    }

    public void setId(long id){
        this.id = id;
    }
    public long getId(){
        return id;
    }
    public void setFullName(String fullName){
        this.fullName = fullName;
    }
    public String getFullName(){
        return fullName;
    }

    public void setDepartment(String department){
        this.department = department;
    }
    public String getDepartment(){
        return department;
    }
    public void setTicket(List<Ticket> ticket){
        this.ticket = ticket;
    }
    public List<Ticket> getTicket(){
        return ticket;
    }

    public void addTicket(Ticket singleTicket){
        ticket.add(singleTicket);
    }
}
