package com.example.couponservice.exception;

public class CouponNotFoundException extends RuntimeException{
	
	private String errorMessage="";

	public CouponNotFoundException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}
	
	@Override
    public String getMessage() {
        return errorMessage;
    }

}
