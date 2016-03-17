package com.bootcamp.test;

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
import com.bootcamp.FinalProject.controller.ProductController;
import com.bootcamp.FinalProject.entity.Category;
import com.bootcamp.FinalProject.entity.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class ProductControllerTest {
    
    @Autowired
    private ProductController productController;
    
    @Autowired
    private CategoryController categoryController;
    
    private Category category1;
    
    private Category category2;
    
    private Product product;

    @Before
    public void loadData() {
        category1 = new Category();
        category1.setName("Books");
        category1.setName("All kinds of printed material");
        category1 = categoryController.addCategory(category1);
        category2 = new Category();
        category2.setName("DVD");
        category2.setDescription("Videos");
        category2 = categoryController.addCategory(category2);
        product = new Product();
        product.setName("Game of Throne A Song of Ice and Fire");
        product.setDescription("Epic book");
        product.setPrice(1000);
        product.setCategory(category1);
        product = productController.addProduct(product);
    }

    @After
    public void deleteData() {
        productController.deleteProduct(product.getId());
        categoryController.deleteCategory(category1.getId());
        categoryController.deleteCategory(category2.getId());
    }

    @Test
    public void addAndDeleteProductTest() {
        assertNotNull(productController.findById(product.getId()));
    }

    @Test
    public void updateProductTest() {
        product.setCategory(category2);
        product.setDescription("Some book");
        productController.updateProduct(product.getId(), product);
        Product updatedProduct = productController.findById(product.getId());
        assertEquals(product.getCategory().getId(), updatedProduct.getCategory().getId());
        assertEquals(product.getDescription(), updatedProduct.getDescription());
    }
}
