package com.codewithdurgesh.blog.services.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.asm.Advice.This;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithdurgesh.blog.entities.Category;
import com.codewithdurgesh.blog.exceptions.ResourceNotFoundException;
import com.codewithdurgesh.blog.payloads.CategoryDto;
import com.codewithdurgesh.blog.repositories.CategoryRepo;
import com.codewithdurgesh.blog.services.CategoryService;


@Service
public class CategoryServiceImpl implements CategoryService 
{

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) 
	{
		// TODO Auto-generated method stub
		Category cat = this.modelMapper.map(categoryDto, Category.class);
		Category addedCat = this.categoryRepo.save(cat);
		
		return this.modelMapper.map(addedCat, CategoryDto.class);
	}

	
	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categotyId) 
	{
		// TODO Auto-generated method stub
		Category cat = this.categoryRepo.findById(categotyId)
				.orElseThrow(()-> new ResourceNotFoundException("Category", "Category Id", categotyId));
		
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		
		Category updatedcat = this.categoryRepo.save(cat);
		
		return this.modelMapper.map(updatedcat, CategoryDto.class);
	}

	
	@Override
	public void deleteCategory(Integer categotyId) 
	{
		// TODO Auto-generated method stub
		Category cat = this.categoryRepo.findById(categotyId).orElseThrow(()-> new ResourceNotFoundException("Category", "category id", categotyId));
		
		this.categoryRepo.delete(cat);

	}

	@Override
	public CategoryDto getCategory(Integer categotyId) 
	{
		// TODO Auto-generated method stub
		Category cat = this.categoryRepo.findById(categotyId).orElseThrow(()-> new ResourceNotFoundException("Category", "category id", categotyId));
		
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	
	@Override
	public List<CategoryDto> getCategories() 
	{
		// TODO Auto-generated method stub
		List<Category> categories = this.categoryRepo.findAll();
		
		List<CategoryDto> catDtos = categories.stream().map((cat)-> this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		
		
		return catDtos;
	}

}
