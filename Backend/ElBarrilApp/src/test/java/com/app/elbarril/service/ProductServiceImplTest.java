package com.app.elbarril.service;

import com.app.elbarril.dao.IProductDAO;
import com.app.elbarril.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.Arrays;

import static org.mockito.Mockito.when;

class ProductServiceImplTest {

    @Mock
    private IProductDAO productDAO;

    @InjectMocks
    private ProductServiceImpl productServiceimpl;

    private Product product;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        product =  new Product();
        product.setName("Yamille");
        product.setDescription("ABC");
        product.setPrice(12);
        product.setQuantity(23);
        product.setCategory("Cerveza");
        product.setImage("CervezaCristal.jpg");
        product.setRating(5);

    }

    @Test
    void findAll() {
        when(productDAO.findAll()).thenReturn(Arrays.asList(product));
        assertNotNull(productServiceimpl.findAll());
    }
}