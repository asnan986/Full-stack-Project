package com.dxc.eshop.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import com.dxc.eshop.entity.Product;
import com.dxc.eshop.entity.ProductCategory;

@Configuration
public class RestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManger;
    
    @Autowired
    public RestConfig(EntityManager entityManger) {
          this.entityManger=entityManger;
	}

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		HttpMethod[] unsupportedActions= {HttpMethod.POST,HttpMethod.PUT,HttpMethod.DELETE,HttpMethod.PATCH};
		config.getExposureConfiguration().forDomainType(Product.class).withItemExposure((metadata,httpMethods)->httpMethods.disable(unsupportedActions));
		config.getExposureConfiguration().forDomainType(ProductCategory.class).withItemExposure((metadata,httpMethods)->httpMethods.disable(unsupportedActions));
		exposeIds(config);
	}
	
	private void exposeIds(RepositoryRestConfiguration config) {
		
		//get all entities from entity manager
		Set<EntityType<?>> entities = entityManger.getMetamodel().getEntities();
		
		//create an array of all entity type
		List<Class> entityClasses = new ArrayList<>();
		
		for(EntityType entityType:entities) {
			entityClasses.add(entityType.getJavaType());
		}
		
		Class[] domainTypes = entityClasses.toArray(new Class[0]);
		 config.exposeIdsFor(domainTypes);
	}

}
