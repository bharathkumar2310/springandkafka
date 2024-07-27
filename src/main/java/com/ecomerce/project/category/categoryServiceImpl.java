package com.ecomerce.project.category;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class categoryServiceImpl implements categoryService {
	
	@Autowired
	private categoryRepo catRepo;
	
	@Override
	public List<categoryModel> getAllCategories() {
		return catRepo.findAll();
	}

	@Override
	public void createCategories(categoryModel categoryModel) {
     	catRepo.save(categoryModel);
	}

	@Override
	public String deleteCatagory(Long categoryId) {
		categoryModel categoryModel =catRepo.findById(categoryId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource not Found"));

		catRepo.delete(categoryModel);
		return "CategoryId " + categoryModel.getCategoryId() + " deleted successfully";
	}

	@Override
	public categoryModel updateCategory(categoryModel catModel , Long categoryId) {
		categoryModel categoryModel =catRepo.findById(categoryId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource not Found"));
		catModel.setCategoryId(categoryId);
		categoryModel savedCatModel = catRepo.save(catModel);
		return savedCatModel;
			
		
		
	}
	

}