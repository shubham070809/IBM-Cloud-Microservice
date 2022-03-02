package com.example.couponservice.service;

import java.util.List;

import com.example.couponservice.dto.CouponDto;

public interface CouponService {
	
	public CouponDto createCoupon(CouponDto couponDto);
	public List<CouponDto> getCoupons();
	public CouponDto findCouponByCouponCode(String couponCode);

}
