package com.Incident.Incident.entities;


import jakarta.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "ticketName")
    private String ticketName;

    @Column(name = "ticketDescription")
    private String ticketDescription;

    @JoinColumn(name = "employee")
    @ManyToOne
    private Employee employee;

    @Column(name = "status")
    private Status status = Status.BACKLOG;


    public Ticket(){
    }

    public void setId(long id){
        this.id = id;
    }
    public long getId(){
        return id;
    }
    public void setTicketName(String ticketName){
        this.ticketName = ticketName;
    }
    public String getTicketName(){
        return ticketName;
    }
    public void setTicketDescription(String ticketDescription){
        this.ticketDescription = ticketDescription;
    }
    public String getTicketDescription(){
        return ticketDescription;
    }
    public void setStatus(Status status){
        this.status = status;
    }
    public Status getStatus(){
        return status;
    }
}
