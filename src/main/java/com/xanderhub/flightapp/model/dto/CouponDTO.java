package com.xanderhub.flightapp.model.dto;

public class CouponDTO {
    public final double price;
    public final String msg;

    public CouponDTO(double price, String msg) {
        this.price = price;
        this.msg = msg;
    }
}
