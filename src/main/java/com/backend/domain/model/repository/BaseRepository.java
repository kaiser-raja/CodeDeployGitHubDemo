package com.backend.domain.model.repository;


import com.backend.domain.model.BaseEntity;
import com.backend.domain.model.exception.DomainException;

public interface BaseRepository<E extends BaseEntity> extends GenericRepository<Integer, E> {
	E save(E entity) throws DomainException;


    E saveWithoutFlush(E entity) throws DomainException;
}