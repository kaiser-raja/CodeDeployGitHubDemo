package com.backend.infrastructure.persistence;





import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.domain.model.Country;
import com.backend.domain.model.User;
import com.backend.domain.model.repository.CountryRepository;



@Repository
@Transactional
public class CountryRepositoryImpl extends BaseRepositoryImpl<User> implements CountryRepository {

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
	public void delete(Country arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Country> arg0) {
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
	public Iterable<Country> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Country> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Country findOne(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Country> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Country> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Country findCountryByName(String name) {
		Country country = null;
        TypedQuery<Country> query = em.createNamedQuery("findCountryByName", Country.class);
        query.setParameter("name", name);
        try {
        	country = query.getSingleResult();
        } catch (NoResultException e) {
            LOG.error(e.getMessage());
        }
		return country;
	} 
}
