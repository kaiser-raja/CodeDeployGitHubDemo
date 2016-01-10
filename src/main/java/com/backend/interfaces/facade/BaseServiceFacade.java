package com.backend.interfaces.facade;

import java.util.List;
import java.util.Map;

public interface BaseServiceFacade {
    public <S, T> List<T> mapDomainObjectList(List<S> domainObjectList, Class<T> destinationClass, String lang);

    public <S, T> T mapDomainObject(S domainObject, Class<T> destinationClass);

    public <S, T> T mapDomainObject(S domainObject, Class<T> destinationClass, String mapId, String lang);
    
    public <S, T> T mapObject(S sourceObject, Class<T> destinationClass, Map<String, String> customFieldMapping);
}