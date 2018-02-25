package shabtay.coupon.system.facade;

import shabtay.coupon.system.exceptions.WrongLoginInputException;

/**
 *
 * this Interface is implemented by Facades and DBDAO'
 * 
 */

public interface CouponClientFacade {

	/**
	 * 
	 * @param name
	 *            user name
	 * @param password
	 *            user's password
	 * @return CouponClientFacade or null
	 * @throws WrongLoginInputException
	 *             Exception is thrown in case Login input is Wrong
	 */
	CouponClientFacade login(String name, String password) throws WrongLoginInputException;

}
