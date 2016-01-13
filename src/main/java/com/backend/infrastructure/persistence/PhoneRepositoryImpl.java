package com.backend.infrastructure.persistence;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.backend.domain.model.Phone;
import com.backend.domain.model.repository.PhoneRepository;

public class PhoneRepositoryImpl extends BaseRepositoryImpl<Phone> implements PhoneRepository {

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
	public void delete(Phone arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Phone> arg0) {
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
	public Iterable<Phone> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Phone> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Phone findOne(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Phone> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Phone> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Phone findByCountryCodeAndPhoneNumber(String countryCode,
			String phoneNumber) {
		Phone phone = null;
        TypedQuery<Phone> query = em.createNamedQuery("findPhoneByCountryCodeAndPhoneNumber", Phone.class);
        query.setParameter("countryCode", countryCode);
        query.setParameter("phoneNumber", phoneNumber);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            LOG.error(e.getMessage());
        }
		return phone;
	}

}
