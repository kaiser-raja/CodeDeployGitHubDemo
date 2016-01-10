package com.backend.domain.model.repository;

import com.backend.domain.model.exception.DomainException;

public interface GenericRepository<K, E> {

    public void detach(E entity) throws DomainException;

    public E findById(K id) throws DomainException;

    public E findLockedEntityById(K id) throws DomainException;

    public void persist(E entity) throws DomainException;

    public E merge(E entity) throws DomainException;

    public void flush() throws DomainException;

    public void remove(E entity) throws DomainException;

    public void refresh(E entity) throws DomainException;

    public void refreshLockedEntity(E entity) throws DomainException;

    public void lock(E entity) throws DomainException;

}