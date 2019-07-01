package com.xanderhub.flightapp.controller;

import com.xanderhub.flightapp.model.CheckIn;
import com.xanderhub.flightapp.model.dto.CheckInDTO;
import com.xanderhub.flightapp.model.dto.CouponDTO;
import com.xanderhub.flightapp.service.FlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class FlightController {

    private static Logger LOG = LoggerFactory.getLogger(FlightController.class);

    private final FlightService flightSercice;

    public FlightController(FlightService flightSercice) {
        this.flightSercice = flightSercice;
    }

    @RequestMapping(value = "/tickets", method = RequestMethod.GET)
    public Boolean isTicketAvailable(@RequestParam(value = "ticketId") long ticketId,
                                     HttpServletRequest request) {
        LOG.info("GET Request: {}?{}", request.getRequestURI(), request.getQueryString());
        return flightSercice.isTicketAvailable(ticketId);
    }

    @RequestMapping(value = "/coupons", method = RequestMethod.GET)
    public CouponDTO getDiscountCoupon(@RequestParam(value = "couponId") long couponId,
                                       @RequestParam(value = "price") double price,
                                       HttpServletRequest request) {
        LOG.info("GET Request: {}?{}", request.getRequestURI(), request.getQueryString());
        return flightSercice.getDiscountCoupon(couponId, price);
    }

    @RequestMapping(value = "/checkIn", method = RequestMethod.POST)
    public Boolean checkIn(@RequestBody CheckInDTO checkInDTO, HttpServletRequest request) {
        //TODO: refactor - create converter DAO -> DTO
        LOG.info("GET Request: {} -> {}", request.getRequestURI(), request.getQueryString());
        return flightSercice.checkIn(new CheckIn(checkInDTO.destinationId, checkInDTO.baggageId));
    }
}
