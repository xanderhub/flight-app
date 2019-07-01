package com.xanderhub.flightapp.model;

import javax.persistence.*;

@Entity
@Table(name = "checkins", indexes = {@Index(name = "i_dest_baggage", columnList = "destinationId, baggageId", unique = true)})
public class CheckIn {
    @Id
    private int destinationId;
    private String baggageId;

    public CheckIn(int destinationId, String baggageId) {
        this.destinationId = destinationId;
        this.baggageId = baggageId;
    }

    public CheckIn() {
    }

    public int getDestinationId() {
        return destinationId;
    }

    public String getBaggageId() {
        return baggageId;
    }
}
