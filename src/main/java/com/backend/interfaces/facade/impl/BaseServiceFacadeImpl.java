package com.backend.interfaces.facade.impl;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;






import java.util.Map;
import java.util.Map.Entry;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.backend.interfaces.facade.*;

@Component
public class BaseServiceFacadeImpl implements BaseServiceFacade { // NO_UCD (use
    // default)
    @SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(BaseServiceFacadeImpl.class);
    
    
    @Override
    public <S, T> List<T> mapDomainObjectList(List<S> domainObjectList, Class<T> destinationClass, String lang) {
        return null;
    }

    public <S, T> List<T> mapDomainObjectList(List<S> domainObjectList, Class<T> destinationClass, String mapId, String lang) {
        List<T> modelObjList = new ArrayList<T>();
       
        return modelObjList;
    }

    @Override
    public <S, T> T mapDomainObject(S domainObject, Class<T> destinationClass) {
    	return null;
    }

    @Override
    public <S, T> T mapDomainObject(S domainObject, Class<T> destinationClass, String mapId, String lang) {
       return null;
    }
    
    @SuppressWarnings("rawtypes")
	@Override
    public <S, T> T mapObject(S sourceObject, Class<T> destinationClass, Map<String, String> customFieldMapping) {
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
		ClassMapBuilder<? extends Object, T> map = mapperFactory.classMap(sourceObject.getClass(), destinationClass);
		
		if (customFieldMapping != null) {
			Iterator<Entry<String, String>> it = customFieldMapping.entrySet().iterator();
			while (it.hasNext()) {
			      Map.Entry pairs = (Map.Entry)it.next();
			      System.out.println(pairs.getKey() + " = " + pairs.getValue());
			      map.field(pairs.getKey().toString(), pairs.getValue().toString());
			      it.remove(); // avoids a ConcurrentModificationException
			    }
		}
	    map.byDefault().register();
	    MapperFacade mapper = mapperFactory.getMapperFacade();
	     
		T destination = (T) mapper.map(sourceObject, destinationClass);
		return destination;
	}
}