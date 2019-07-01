package com.xanderhub.flightapp.repository;

import com.xanderhub.flightapp.model.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
    Ticket findByTicketId(long ticketId);
}
