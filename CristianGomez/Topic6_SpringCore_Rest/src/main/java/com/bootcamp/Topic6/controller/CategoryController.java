package com.bootcamp.Topic6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.Topic6.entity.Category;
import com.bootcamp.Topic6.service.ICategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/category")
@ComponentScan("com.bootcamp.Topic6")
@Api(value = "Category", description = "All operations related to product's categories")
public class CategoryController {

	@Autowired
	private ICategoryService iCategoryService;

	@ApiOperation(value = "List of all categories")
	@RequestMapping(method = RequestMethod.GET)
	public List<Category> listAllCategories() {
		return iCategoryService.listAllCategories();
	}

	@ApiOperation(value = "Retrieve a category using its id")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path") })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Category findById(@PathVariable(value = "id") int categoryId) {
		return iCategoryService.findById(categoryId);
	}

	@ApiOperation(value = "Delete a category using its id")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path") })
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteCategory(@PathVariable(value = "id") int categoryId) {
		iCategoryService.deleteCategory(iCategoryService.findById(categoryId));
	}

	@ApiOperation(value = "Update a category using its id")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void updateCategory(@PathVariable(value = "id") int categoryId, @RequestBody Category category) {
		iCategoryService.updateCategory(category);
	}

	@ApiOperation(value = "Add a new category to the system")
	@RequestMapping(method = RequestMethod.POST)
	public Category addCategory(@RequestBody Category category) {
		return iCategoryService.addCategory(category);
	}
}
