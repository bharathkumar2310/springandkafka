package com.ecomerce.project.category;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class categoryModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long categoryId;

	private String categoryName;
	
	public Long getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	@Override
	public String toString() {
		return "categoryModel [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}
	

}
