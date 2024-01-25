package com.codewithdurgesh.blog.services;

import java.util.List;

import com.codewithdurgesh.blog.payloads.CategoryDto;

public interface CategoryService 
{
	//create
	public CategoryDto createCategory(CategoryDto categoryDto);
	
	//update
	public CategoryDto updateCategory(CategoryDto categoryDto,Integer categotyId);
	
	//delete
	public void deleteCategory(Integer categotyId);
	
	//get
	public CategoryDto getCategory(Integer categotyId);
	
	//get all
	List<CategoryDto> getCategories();

}
