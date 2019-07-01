package com.xanderhub.flightapp.service;

import com.xanderhub.flightapp.model.CheckIn;
import com.xanderhub.flightapp.model.dto.CouponDTO;
import com.xanderhub.flightapp.repository.CheckInRepository;
import com.xanderhub.flightapp.repository.CouponRepository;
import com.xanderhub.flightapp.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {
    private final TicketRepository ticketRepository;
    private final CouponRepository couponRepository;
    private final CheckInRepository checkInRepository;

    @Autowired
    public FlightService(TicketRepository ticketRepository, CouponRepository couponRepository, CheckInRepository checkInRepository) {
        this.ticketRepository = ticketRepository;
        this.couponRepository = couponRepository;
        this.checkInRepository = checkInRepository;
    }

    public Boolean isTicketAvailable(final long ticketId){
        return ticketRepository.findByTicketId(ticketId) != null;
    }

    public CouponDTO getDiscountCoupon(final long couponId, final double price){
        if(couponRepository.findByCouponId(couponId) != null)
            return new CouponDTO(randomDiscount(price), "Coupon is valid");
        return new CouponDTO(price, "Coupon is not valid!");
    }

    public Boolean checkIn(final CheckIn checkIn){
        return checkInRepository.save(checkIn) != null;
    }

    private double randomDiscount(double price){
        //TODO: refactor random picker
        return price - price * 0.5;
    }
}
