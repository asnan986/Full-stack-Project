package com.dxc.eshop.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name="product")
public class Product {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private String sku;
	
	@ManyToOne
	@JoinColumn(name="category_id",nullable = false)
	private ProductCategory category;
	
	private String name;
	
	private String description;
	
	@Column(name="unit_price")
	private BigDecimal unitPrice;
	
	@Column(name="image_url")
	private String imageUrl;
	
	private Boolean active;
	
	@Column(name="units_in_stock")
	private Integer unitsinstock;
	
	@Column(name="date_created")
	@CreationTimestamp
	private Date creationDate;
	
	@Column(name="last_updated")
	@UpdateTimestamp
	private Date updatedDate;

}
