package com.carrito.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.carrito.entities.Category;
import com.carrito.services.ICategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


@EnableAutoConfiguration
@RestController
@RequestMapping("/category")
@ComponentScan("com.carrito")
@Api(value = "Category", description = "category Controller", produces = "application/json")
public class CategoryController {
	
	@Autowired
	private ICategoryService iCategoryService;
	
	@ApiOperation(value = "Show the list of all categories")
	@RequestMapping(method = RequestMethod.GET)
	public List<Category> listAllCategories() {
		return iCategoryService.listAllCategories();
	}
	
	@ApiOperation(value = "Show the category for a given id")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", required = true, dataType = "Integer") })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Category findById(@PathVariable(value = "id") Integer categoryId) {
		return iCategoryService.findById(categoryId);
	}
	
	@ApiOperation(value = "Delete the category for a given id")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", required = true, dataType = "Integer") })
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteCategory(@PathVariable(value = "id") Integer categoryId) {
		iCategoryService.deleteCategory(iCategoryService.findById(categoryId));
	}
	
	@ApiOperation(value = "Update the category for a given id")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", required = true, dataType = "Integer") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void updateCategory(@PathVariable(value = "id") Integer categoryId, @RequestBody Category category) {
		iCategoryService.updateCategory(category);
	}
	
	@ApiOperation(value = "Add a new category")
	@RequestMapping(method = RequestMethod.POST)
	public Category addCategory(@RequestBody Category category) {
		return iCategoryService.addCategory(category);
	}

}
