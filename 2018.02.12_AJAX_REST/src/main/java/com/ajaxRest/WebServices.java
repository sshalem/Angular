package com.ajaxRest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebServices {

	List<Coupon> coupons = new ArrayList<Coupon>();

	public WebServices() {
		coupons.add(new Coupon(1, "Caffe"));
		coupons.add(new Coupon(2, "Movie VIP"));
		coupons.add(new Coupon(3, "Sky jump"));
	}

	// get All coupons
	@RequestMapping(value = "/coupon", method = RequestMethod.GET)
	public List<Coupon> doGetCoupons() {
		return coupons;
	}

	// get coupon by Id
	@RequestMapping(value = "/coupon/{id}", method = RequestMethod.GET)
	public Coupon doGetCouponById(@PathVariable("id") int id) {
		for (Coupon c : coupons) {
			if (c.getId() == id) {
				return c;
			}
		}
		return null;
	}
	
	// POST - add/insert new coupon to DB
	@RequestMapping( value = "/coupon", method = RequestMethod.POST)
	public String doPostCoupons(@RequestBody Coupon c)
	{
		coupons.add(c);
		return "Success!";
	}
	
	// PUT - Update coupon 
	@RequestMapping( value = "/coupon/{id}", method = RequestMethod.PUT)
	public String doPutCoupons(@RequestBody Coupon sent, @PathVariable("id") int id)
	{
		for(Coupon c : coupons)
		{
			if (c.getId() == id)
			{
				c.setId( sent.getId());
				c.setTitle( sent.getTitle());
				return "UPDATED!";
			}
		}
		return "NOT FOUND!";
	}
	
	@RequestMapping( value = "/coupon/{id}", method = RequestMethod.DELETE)
	public String doDeleteCoupons(@PathVariable("id") int id)
	{
		Iterator<Coupon> iter = coupons.iterator();
		while(iter.hasNext())
		{
			Coupon c = iter.next();
			if(c.getId() == id)
			{
				iter.remove();
				return "Coupon deleted!";
			}
		}
		return "Coupon not FOUND!";
	}

}
