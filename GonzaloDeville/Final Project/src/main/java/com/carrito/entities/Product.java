package com.carrito.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="product")
@ApiModel(value = "Product entity", description = "Complete data of a entity Product")
public class Product {
	@Id
	@GeneratedValue
	@Column(name = "id")
	@ApiModelProperty(value = "The id of the Product")
	private Integer id;
	
	@Column(name = "productname")
	@ApiModelProperty(value = "The name of the Product")
	private String productName;
	
	@ManyToOne
	@JoinColumn(name = "idcategory")
	@ApiModelProperty(value = "The category of the Product")
	private Category category;
	
	@Column(name = "productdescription")
	@ApiModelProperty(value = "The description of the Product")
	private String productDescription;
	
	@Column(name = "price")
	@ApiModelProperty(value = "The price of the Product")
	private Double price;
		
	public Product(){
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	

	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}

	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return obj != null && obj instanceof Product && id.equals(((Product) obj).getId())
				&& productName.equalsIgnoreCase(((Product)obj).getProductName());
	}
	
	

}
