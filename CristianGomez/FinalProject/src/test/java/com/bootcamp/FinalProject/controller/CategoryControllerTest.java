package com.bootcamp.FinalProject.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.bootcamp.FinalProject.App;
import com.bootcamp.FinalProject.controller.CategoryController;
import com.bootcamp.FinalProject.entity.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class CategoryControllerTest {
    
    @Autowired
    private CategoryController categoryController;
    
    private Category category;

    @Before
    public void loadData() {
        category = new Category();
        category.setName("Books");
        category.setDescription("All kinds of printed material");
        category = categoryController.addCategory(category);
    }

    @After
    public void deleteData() {
        categoryController.deleteCategory(category.getId());
    }

    @Test
    public void addAndDeleteUserTest() {

        assertNotNull(categoryController.findById(category.getId()));
    }

    @Test
    public void updateCategoryTest() {
        category.setDescription("Books and e-books");
        categoryController.updateCategory(category.getId(), category);
        assertEquals(category.getDescription(), categoryController.findById(category.getId()).getDescription());
    }
}
