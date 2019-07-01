package com.xanderhub.flightapp.bootstrap;

import com.xanderhub.flightapp.model.Coupon;
import com.xanderhub.flightapp.model.Ticket;
import com.xanderhub.flightapp.repository.CheckInRepository;
import com.xanderhub.flightapp.repository.CouponRepository;
import com.xanderhub.flightapp.repository.TicketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class FlightAppBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private static Logger LOG = LoggerFactory.getLogger(FlightAppBootstrap.class);

    private final TicketRepository ticketRepository;
    private final CouponRepository couponRepository;

    @Autowired
    public FlightAppBootstrap(TicketRepository ticketRepository, CouponRepository couponRepository) {
        this.ticketRepository = ticketRepository;
        this.couponRepository = couponRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        LOG.info("Populating flight app data...");
        ticketRepository.save(new Ticket(100L));
        ticketRepository.save(new Ticket(101L));
        ticketRepository.save(new Ticket(102L));

        couponRepository.save(new Coupon(123456789L));
        couponRepository.save(new Coupon(987654321L));
    }
}
