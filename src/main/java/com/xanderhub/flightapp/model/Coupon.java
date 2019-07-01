package com.xanderhub.flightapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "coupons", indexes = {@Index(name = "i_couponId", columnList = "couponId", unique = true)})
public class Coupon {
    @Id
    private long couponId;

    public Coupon(long couponId) {
        this.couponId = couponId;
    }

    public Coupon() {
    }

    public long getCouponId() {
        return couponId;
    }
}
