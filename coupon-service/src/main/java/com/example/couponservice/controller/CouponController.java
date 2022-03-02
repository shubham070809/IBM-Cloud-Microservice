package com.example.couponservice.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.couponservice.dto.CouponDto;
import com.example.couponservice.service.CouponService;
import com.example.couponservice.ui.CouponResponseModel;
import com.example.couponservice.exception.*;
import java.util.UUID;


@RestController
public class CouponController {
	
	private final ModelMapper modelMapper;
    private final CouponService couponService;
	public CouponController(ModelMapper modelMapper, CouponService couponService) {
		super();
		this.modelMapper = modelMapper;
		this.couponService = couponService;
	}
	
	@ExceptionHandler
    public ResponseEntity<ErrorResponse> handleError(CouponNotFoundException e)
    {
        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setErrorMessage(e.getMessage());
        errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorResponse.setErrorReportingTime(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
    
	@PostMapping("/coupons")
    public ResponseEntity<CouponResponseModel> createCoupon()
    {
    	/*This model mapper is used to matching here */
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        
        /*Here we are converting it to UserDto type as with help of model mapper and also because 
         * User data from postman is of userRequestModel type but as id is being generated in the userDto
         * therefore we use userDto obj to inject the val for id therefore we convert it to userDto.
         * Then as we need to return the value as UserResponseModel therefore using mapper to convert to the req
         * class and then returning.*/
        Double discount=1.0* (new Random().nextInt(100));
        CouponDto couponDto=new CouponDto(UUID.randomUUID().toString(),discount);
        couponDto=couponService.createCoupon(couponDto);
        
        /*Here we are using userResponseModel as user need to only see his essentials removing the password*/
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(couponDto,CouponResponseModel.class));
    }
	
	
	@GetMapping("/coupons")
    public ResponseEntity<List<CouponResponseModel>> getCoupons()
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<CouponResponseModel> list=new ArrayList<>();
        List<CouponDto> dtos=couponService.getCoupons();
        for (CouponDto d:dtos)
        {
            list.add(modelMapper.map(d,CouponResponseModel.class));
        }
        return ResponseEntity.ok(list);
    }
	
	
	@GetMapping("couponsByCode/{couponCode}")
    public ResponseEntity<CouponResponseModel> findCouponByCouponCode(@PathVariable("couponCode") String couponCode)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return ResponseEntity.ok(modelMapper.map(couponService.findCouponByCouponCode(couponCode),CouponResponseModel.class));

    }
    

}
