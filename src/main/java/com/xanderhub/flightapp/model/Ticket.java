package com.xanderhub.flightapp.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "tickets", indexes = {@Index(name = "i_ticketId", columnList = "ticketId", unique = true)})
public class Ticket {
    @Id
    private long ticketId;

    public Ticket(long ticketId) {
        this.ticketId = ticketId;
    }

    public Ticket() {
    }

    public long getTicketId() {
        return ticketId;
    }
}
