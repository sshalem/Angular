package shabtay.coupon.system.facade;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shabtay.coupon.system.DBDAO.CompanyDBDAO;
import shabtay.coupon.system.DBDAO.CouponDBDAO;
import shabtay.coupon.system.DBDAO.CustomerDBDAO;
import shabtay.coupon.system.entities.Company;
import shabtay.coupon.system.entities.Coupon;
import shabtay.coupon.system.entities.Customer;
import shabtay.coupon.system.exceptions.CompanyAlreadyExistException;
import shabtay.coupon.system.exceptions.CustomerAlreadyExistException;
import shabtay.coupon.system.exceptions.WrongLoginInputException;

/**
 * Class AdminFacade gives the administrator access to all the data of Customers
 * and Companies
 * 
 * @author Shabtay Shalem
 *
 */
@Component
public class AdminFacade implements CouponClientFacade {

	@Autowired
	CompanyDBDAO companyDBDAO;

	@Autowired
	CustomerDBDAO customerDBDAO;

	@Autowired
	CouponDBDAO couponDBDAO;

	public AdminFacade() {
		super();
	}

	@Override
	public CouponClientFacade login(String name, String password) throws WrongLoginInputException {

		if ((password.equals("1234")) && (name.equals("admin"))) {
			return this;
		}
		throw new WrongLoginInputException(" .......  wrong Admin  UserName/Password/ClientType entered ......");
	}

	/**
	 * Creates new company
	 * 
	 * @param newCompany
	 *            is the company to add
	 * @throws CompanyAlreadyExistException
	 *             Exception is thrown in case company with same CompanyName exists 
	 * @throws InterruptedException 
	 */
	public void createCompany(Company newCompany) throws CompanyAlreadyExistException, InterruptedException {

		if (companyDBDAO.getCompanyByName(newCompany.getCompName()) != null)
			throw new CompanyAlreadyExistException("   " + newCompany.getCompName() + "  ... already exists...\n");
		companyDBDAO.createCompany(newCompany);
	}

	/**
	 * Removes a Company
	 * 
	 * @param company
	 *            The company to be removed
	 * @throws InterruptedException 
	 */
	public void removeCompany(Company company) throws InterruptedException {
		companyDBDAO.removeCompany(company);
	}

	/**
	 * Updates Company
	 * 
	 * @param company
	 *            The company to be updated
	 * @throws InterruptedException 
	 */
	public void updateCompany(Company company) throws InterruptedException {
		companyDBDAO.updateCompany(company);
	}

	/**
	 * Get Company details by Company Id
	 * 
	 * @param id
	 *            company Id
	 * @return Company
	 * @throws InterruptedException 
	 */
	public Company getCompany(long id) throws InterruptedException {
		return companyDBDAO.getCompany(id);
	}

	/**
	 * Get Company details by Company name
	 * 
	 * @param name
	 *            Company name
	 * @return Company
	 * @throws InterruptedException 
	 */
	public Company getCompByName(String name) throws InterruptedException {
		return companyDBDAO.getCompanyByName(name);
	}

	/**
	 * Get all the Companies in Data Base
	 * 
	 * @return Collection of Company
	 * @throws InterruptedException 
	 */
	public Collection<Company> getAllCompanies() throws InterruptedException {
		return companyDBDAO.getAllCompanies();
	}

	public Collection<Coupon> getAllCoupon() throws InterruptedException {
		return couponDBDAO.getAllCoupon();
	}

	/**
	 * Creates new Customer
	 * 
	 * @param newCustomer
	 *            is the Customer to add
	 * @throws CustomerAlreadyExistException
	 *             Exception is thrown in case Customer with same CustomerName
	 *             exists
	 * @throws InterruptedException 
	 */
	public void createCustomer(Customer newCustomer) throws CustomerAlreadyExistException, InterruptedException {

		if (customerDBDAO.getCustomerByName(newCustomer.getCustName()) != null)
			throw new CustomerAlreadyExistException("   " + newCustomer.getCustName() + "  ... already exists...\n");
		customerDBDAO.createCustomer(newCustomer);
	}

	/**
	 * Remove Customer From DB
	 * 
	 * @param customer
	 *            The Customer to be removed
	 * @throws InterruptedException 
	 */
	public void removeCustomer(Customer customer) throws InterruptedException {
		customerDBDAO.removeCustomer(customer);
	}

	/**
	 * Update Customer From DB
	 * 
	 * @param customer
	 *            The customer to be updated
	 * @throws InterruptedException 
	 */
	public void updateCustomer(Customer customer) throws InterruptedException {
		customerDBDAO.updateCustomer(customer);
	}

	/**
	 * Get Customer details by Customer Id
	 * 
	 * @param id
	 *            customer ID
	 * @return Customer
	 * @throws InterruptedException 
	 */
	public Customer getCustomer(long id) throws InterruptedException {
		return customerDBDAO.getCustomer(id);
	}

	/**
	 * Get all customers from DB
	 * 
	 * @return Collection of Customer
	 * @throws InterruptedException 
	 */
	public Collection<Customer> getAllCustomer() throws InterruptedException {
		return customerDBDAO.getAllCustomer();
	}

	/**
	 * Get Customer details by customer name
	 * 
	 * @param custName
	 *            Customer name
	 * @return Customer
	 * @throws InterruptedException 
	 */
	public Customer getCustomerByName(String custName) throws InterruptedException {
		return customerDBDAO.getCustomerByName(custName);
	}	

	/**
	 * Delete coupon who's date is expired
	 * @param today Today's date
	 */
	public void deleteExpiredCoupons(Date today) {
		couponDBDAO.deleteExpiredCoupons(today);
	}

}
