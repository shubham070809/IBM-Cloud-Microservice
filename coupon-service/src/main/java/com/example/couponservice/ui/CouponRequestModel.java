package com.example.couponservice.ui;

public class CouponRequestModel {
	
    private Double discount;

	public CouponRequestModel() {
		super();
	}

	public CouponRequestModel(Double discount) {
		super();
		this.discount = discount;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}
    
    
}
