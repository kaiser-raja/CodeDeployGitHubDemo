package com.backend.infrastructure.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.backend.domain.model.BaseEntity;
import com.backend.domain.model.exception.DomainException;
import com.backend.domain.model.repository.BaseRepository;

@Repository
public abstract class BaseRepositoryImpl<E extends BaseEntity> extends GenericRepositoryImpl<Integer, E> implements
        BaseRepository<E> { // NO_UCD (use default)

    protected static final Logger LOG = LoggerFactory.getLogger(BaseRepositoryImpl.class);
	@PersistenceContext(unitName = "foodies")
	protected EntityManager em;
    
    @Override
    public E save(E entity) throws DomainException {
        entity = saveWithoutFlush(entity);

        flush();

        return entity;
    }

    @Override
    public E saveWithoutFlush(E entity) throws DomainException {
		return entity;
       /* if (entity.getId() != null) {
            return merge(entity);
        } else {
            persist(entity);
            return entity;
        }*/
    }

}