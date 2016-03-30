package com.finalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.finalProject.entity.Category;
import com.finalProject.service.ICategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;




@EnableAutoConfiguration
@RestController
@RequestMapping("/category")
@ComponentScan("com.carrito")
@Api(value = "Category", description = "Category API", produces = "application/json")
public class CategoryController {
	
	@Autowired
	private ICategoryService iCategoryService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "list Category", notes = "Returns all Categories")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Exits one Category at least")
    })
	public List<Category> listAllCategories() {
		return iCategoryService.listAllCategories();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "find Category", notes = "Return a category")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Exits one Category at least")
    })
	public Category findById(@PathVariable(value = "id") Integer categoryId) {
		return iCategoryService.findById(categoryId);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "delete Category", notes = "delete a category")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Exits one Category at least")
    })
	public void deleteCategory(@PathVariable(value = "id") Integer categoryId) {
		iCategoryService.deleteCategory(iCategoryService.findById(categoryId));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "update Category", notes = "update a category")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Exits one Category at least")
    })
	public void updateCategory(@PathVariable(value = "id") Integer categoryId, @RequestBody Category category) {
		iCategoryService.updateCategory(category);
	}
	
	@RequestMapping(method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "add Category", notes = "Return a category")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Exits one Category at least")
    })
	public Category addCategory(@RequestBody Category category) {
		return iCategoryService.addCategory(category);
	}

}
