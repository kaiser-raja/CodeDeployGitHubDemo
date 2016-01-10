package com.backend.infrastructure.persistence;




import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.domain.model.User;
import com.backend.domain.model.repository.UserRepository;


@Repository
@Transactional
public class UserRepositoryImpl extends BaseRepositoryImpl<User> implements UserRepository { 
	
	protected static final Logger LOG = LoggerFactory.getLogger(UserRepositoryImpl.class);

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
	public void delete(User arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends User> arg0) {
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
	public Iterable<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<User> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findOne(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByEmail(String email) {
		User user = null;
        TypedQuery<User> query = em.createNamedQuery("findUserByEmail", User.class);
        query.setParameter("email", email.toLowerCase());
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            LOG.error(e.getMessage());
        }
		return user;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public User save(User user) {
		if (user.getId() == null) {
			em.persist(user);
			return user;
		} else {
			return em.merge(user);
		}
	}

	@Override
	public User findByUserName(String userName) {
		User user = null;
        TypedQuery<User> query = em.createNamedQuery("findByUsername", User.class);
        query.setParameter("userName", userName);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            LOG.error(e.getMessage());
        }
		return user;
	}
}
