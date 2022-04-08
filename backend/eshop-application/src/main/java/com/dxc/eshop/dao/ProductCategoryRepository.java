package com.dxc.eshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.dxc.eshop.entity.ProductCategory;

@RepositoryRestResource(collectionResourceRel = "productCategorys",path="productCategorys")
@CrossOrigin
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}
