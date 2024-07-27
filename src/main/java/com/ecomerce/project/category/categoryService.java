package com.ecomerce.project.category;

import java.util.List;

public interface categoryService {

	public List<categoryModel> getAllCategories();
	public void createCategories(categoryModel categoryModel);
	public String deleteCatagory(Long categoryId);
	public categoryModel updateCategory(categoryModel catModel, Long categoryId);
	
}
