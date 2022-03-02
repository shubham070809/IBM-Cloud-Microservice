package com.example.couponservice.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.couponservice.entity.CouponEntity;

@Repository
public interface CouponRepository extends CrudRepository<CouponEntity,Integer>{
	@Query
    public CouponEntity findByCouponCode(String userId);
}
