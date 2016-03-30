package com.carrito.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "category")
@ApiModel(value = "Category entity", description = "Complete data of a entity Category")
public class Category {

	@Id
	@GeneratedValue
	@Column(name = "id")
	@ApiModelProperty(value = "The id of the Category")
	private Integer id;

	@Column(name = "name")
	@ApiModelProperty(value = "The name of the Category")
	private String name;

	@Column(name = "description")
	@ApiModelProperty(value = "The description of the Category")
	private String description;
	
	public Category() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return obj != null && obj instanceof Category && id.equals(((Category) obj).getId());
	}

}
