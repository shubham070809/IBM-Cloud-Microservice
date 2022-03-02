package com.example.couponservice.ui;

public class CouponResponseModel {
	
    private String couponCode;
    
    private Double discount;

	public CouponResponseModel() {
		super();
	}

	public CouponResponseModel(String couponCode, Double discount) {
		super();
		this.couponCode = couponCode;
		this.discount = discount;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}
    
    
    

}
