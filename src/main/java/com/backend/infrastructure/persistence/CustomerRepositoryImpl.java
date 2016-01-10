/*package com.backend.infrastructure.persistence;




import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.domain.model.Customer;
import com.backend.domain.model.Phone;
import com.backend.domain.model.repository.CustomerRepository;


@Repository
@Transactional
public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer> implements CustomerRepository { 
	
	protected static final Logger LOG = LoggerFactory.getLogger(CustomerRepositoryImpl.class);

    @Override
    public Customer findByEmail(String email) {
    	Customer customer = null;
        TypedQuery<Customer> query = em.createNamedQuery("findCustomerByEmail", Customer.class);
        query.setParameter("email", email.toLowerCase());
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            LOG.error(e.getMessage());
        }
		return customer;
    }
    
    @Override
    @Transactional
	public Customer findByPhone(Phone phone) {
    	Customer customer = null;
        TypedQuery<Customer> query = em.createNamedQuery("findCustomerByPhone", Customer.class);
        query.setParameter("countryCode", phone.getCountryCode());
        query.setParameter("phoneNumber", phone.getPhoneNumber());
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            LOG.error(e.getMessage());
        }
		return customer;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Customer save(Customer customer) {
		if (customer.getId() == null) {
			em.persist(customer);
			return customer;
		} else {
			return em.merge(customer);
		}
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Customer arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Customer> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Customer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Customer> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findOne(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Customer> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
*/