package com.example.couponservice.dto;

public class CouponDto {

    private String couponCode;
    private Double discount;
	
    public CouponDto() {
		super();
	}

	public CouponDto(String couponCode, Double discount) {
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
