package com.backend.infrastructure.persistence;





import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.domain.model.UserType;

import com.backend.domain.model.repository.UserTypeRepository;



@Repository
@Transactional
public class UserTypeRepositoryImpl extends BaseRepositoryImpl<UserType> implements UserTypeRepository {
	
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
	public void delete(UserType arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends UserType> arg0) {
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
	public Iterable<UserType> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<UserType> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserType findOne(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public UserType findIdByName(String name) {
		UserType userType = null;
        TypedQuery<UserType> query = em.createNamedQuery("findIdByName", UserType.class);
        query.setParameter("name", name);
        try {
        	userType = query.getSingleResult();
        } catch (NoResultException e) {
            LOG.error(e.getMessage());
        }
		return userType;
	}

	@Override
	public <S extends UserType> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends UserType> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	} 
}
