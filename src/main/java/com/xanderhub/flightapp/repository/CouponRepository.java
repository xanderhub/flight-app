package com.xanderhub.flightapp.repository;

import com.xanderhub.flightapp.model.Coupon;
import org.springframework.data.repository.CrudRepository;

public interface CouponRepository extends CrudRepository<Coupon, Long> {
    Coupon findByCouponId(long couponId);
}
