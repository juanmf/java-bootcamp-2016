package com.finalProject.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Info Product", description = "Complete data of a Product Info")

@Entity
@Table(name = "product")
public class Product {
	@ApiModelProperty(value = "the id of the product", required = false)

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@ApiModelProperty(value = "the category of the product", required = false)

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idcategory")
	private Category category;

	@ApiModelProperty(value = "the name of the product", required = false)

	@Column(name = "productname")
	private String productName;

	@ApiModelProperty(value = "the description of the product", required = false)

	@Column(name = "productdescription")
	private String description;

	@ApiModelProperty(value = "the price of the product", required = false)

	@Column(name = "price")
	private Double price;

	public Product() {

	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}


}
