package com.backend.infrastructure.persistence;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.domain.model.exception.DomainException;
import com.backend.domain.model.repository.GenericRepository;

@Repository
@Transactional
public class GenericRepositoryImpl<K, E> implements GenericRepository<K, E> {

	 protected static final Logger LOG = LoggerFactory.getLogger(GenericRepositoryImpl.class);
	 private Class<E> entityClass;
	 
	 @PersistenceContext()
     protected EntityManager entityManager;
	 
	 
		
	 @SuppressWarnings("unchecked")
	    public GenericRepositoryImpl() {
	        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
	        this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[0];
	    }

	    public void start() throws DomainException {
	        try {
	            entityManager.getTransaction().begin();
	        } catch (Exception e) {
	            LOG.error(e.getMessage());
	            throw new DomainException(e);
	        }
	    }

	    public void commit() throws DomainException {
	        try {
	            entityManager.getTransaction().commit();
	        } catch (Exception e) {
	            LOG.error(e.getMessage());
	            throw new DomainException(e);
	        }
	    }

	    @Override
	    public void detach(E entity) throws DomainException {
	        try {
	            entityManager.detach(entity);
	        } catch (Exception e) {
	            LOG.error(e.getMessage());
	            throw new DomainException(e);
	        }
	    }

	    @Override
	    public E findById(K id) throws DomainException {
	        try {
	            return entityManager.find(entityClass, id);
	        } catch (Exception e) {
	            LOG.error(e.getMessage());
	            throw new DomainException(e);
	        }
	    }

	    @Override
	    public E findLockedEntityById(K id) throws DomainException {
	        try {
	            return entityManager.find(entityClass, id, LockModeType.OPTIMISTIC);
	        } catch (Exception e) {
	            LOG.error(e.getMessage());
	            throw new DomainException(e);
	        }
	    }

	    @Override
	    public void persist(E entity) throws DomainException {
	        try {
	            entityManager.persist(entity);
	        } catch (Exception e) {
	            LOG.error(e.getMessage());
	            throw new DomainException(e);
	        }
	    }

	    @Override
	    public E merge(E entity) throws DomainException {
	        try {
	            return entityManager.merge(entity);
	        } catch (Exception e) {
	            LOG.error(e.getMessage());
	            throw new DomainException(e);
	        }
	    }

	    @Override
	    public void flush() throws DomainException {
	        try {
	            entityManager.flush();
	        } catch (Exception e) {
	            LOG.error(e.getMessage());
	            throw new DomainException(e);
	        }
	    }

	    @Override
	    public void remove(E entity) throws DomainException {
	        try {
	            entityManager.remove(entity);
	        } catch (Exception e) {
	            LOG.error(e.getMessage());
	            throw new DomainException(e);
	        }
	    }

	    @Override
	    public void refresh(E entity) throws DomainException {
	        try {
	            entityManager.refresh(entity);
	        } catch (Exception e) {
	            LOG.error(e.getMessage());
	            throw new DomainException(e);
	        }
	    }

	    @Override
	    public void refreshLockedEntity(E entity) throws DomainException {
	        try {
	            entityManager.refresh(entity, LockModeType.OPTIMISTIC);
	        } catch (Exception e) {
	            LOG.error(e.getMessage());
	            throw new DomainException(e);
	        }
	    }

	    @Override
	    public void lock(E entity) throws DomainException {
	        try {
	            entityManager.lock(entity, LockModeType.OPTIMISTIC);
	        } catch (Exception e) {
	            LOG.error(e.getMessage());
	            throw new DomainException(e);
	        }
	    }

}
