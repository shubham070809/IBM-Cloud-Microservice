package com.example.couponservice.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.couponservice.dto.CouponDto;
import com.example.couponservice.entity.CouponEntity;
import com.example.couponservice.exception.CouponNotFoundException;
import com.example.couponservice.repo.CouponRepository;
@Service
public class CouponServiceImpl implements CouponService{

	private final ModelMapper modelMapper;
	private final CouponRepository couponRepository;
	
	@Autowired
	public CouponServiceImpl(ModelMapper modelMapper, CouponRepository couponRepository) {
		super();
		this.modelMapper = modelMapper;
		this.couponRepository = couponRepository;
	}

	@Override
	public CouponDto createCoupon(CouponDto couponDto) {
		// TODO Auto-generated method stub
		
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CouponEntity couponEntity=modelMapper.map(couponDto,CouponEntity.class);
        couponRepository.save(couponEntity);
        return modelMapper.map(couponEntity,CouponDto.class);
	}

	@Override
	public List<CouponDto> getCoupons() {
		// TODO Auto-generated method stub
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	       List<CouponDto> list=new ArrayList<>();
	        Iterable<CouponEntity> iterable= couponRepository.findAll();
	       Iterator<CouponEntity> iterator= iterable.iterator();
	       while (iterator.hasNext())
	       {
	           list.add(modelMapper.map(iterator.next(),CouponDto.class));
	       }
	        return list;
	}

	@Override
	public CouponDto findCouponByCouponCode(String couponCode) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CouponEntity couponEntity= couponRepository.findByCouponCode(couponCode);
        System.out.println(couponEntity);
        if(couponEntity==null)
        {
            throw new CouponNotFoundException("Coupon with code: "+couponCode+" not found");
        }
        return modelMapper.map(couponEntity,CouponDto.class);
	}

}
