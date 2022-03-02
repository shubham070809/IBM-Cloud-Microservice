package com.example.couponservice.entity;

import javax.persistence.*;

@Entity
@Table(name="CouponEntity")
public class CouponEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)// this works with h2 db but not with mysql
	@Column(name="id")
    private Integer couponId;
    
	@Column(name = "coupon_code",unique = true,nullable = false)
    private String couponCode;
    
    @Column(name = "discount",nullable = false)
    private Double discount;

	public CouponEntity() {
		super();
	}

	public CouponEntity(Integer couponId, String couponCode, Double discount) {
		super();
		this.couponId = couponId;
		this.couponCode = couponCode;
		this.discount = discount;
	}

	public Integer getCouponId() {
		return couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
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
