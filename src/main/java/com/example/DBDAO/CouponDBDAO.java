package com.example.DBDAO;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.common.CouponType;
import com.example.entities.Coupon;
import com.example.repository.CouponRepository;

@Component
public class CouponDBDAO implements CouponDAO {

	@Autowired
	CouponRepository couponRepo;

	@Override
	public void createCoupon(Coupon coupon) {
		couponRepo.save(coupon);
	}

	@Override
	public void removeCoupon(Coupon coupon) {
		couponRepo.delete(coupon);
	}

	@Override
	public void updateCoupon(Coupon coupon) {
		couponRepo.save(coupon);
	}

	@Override
	public Coupon getCoupon(long id) {
		return couponRepo.findOne(id);
	}

	@Override
	public Collection<Coupon> getAllCoupon() {
		return (Collection<Coupon>) couponRepo.findAll();
	}

	@Override
	public Collection<Coupon> getCouponByType(CouponType couponType) {
		return couponRepo.findByType(couponType);
	}

	@Override
	public Coupon getCouponByTitle(String title) {
		return couponRepo.findByTitle(title);
	}

	@Override
	public List<Coupon> findByPrice(double price) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	

}
