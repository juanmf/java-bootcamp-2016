package com.finalProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "Info Ctegory", description = "Complete data of a Category Info")
@Entity
@Table(name = "category")
public class Category {
	@ApiModelProperty(value = "the id of the Category", required = false)
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@ApiModelProperty(value = "the name of the Category", required = false)
	@Column(name = "name")
	private String name;
	
	@ApiModelProperty(value = "the description of the Category", required = false)
	@Column(name = "description")
	private String description;
	
	
	public Category() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		Category other = (Category) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
