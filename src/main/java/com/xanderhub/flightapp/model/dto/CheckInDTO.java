package com.xanderhub.flightapp.model.dto;

public class CheckInDTO {
    public final int destinationId;
    public final String baggageId;

    public CheckInDTO(int destinationId, String baggageId) {
        this.destinationId = destinationId;
        this.baggageId = baggageId;
    }
}
