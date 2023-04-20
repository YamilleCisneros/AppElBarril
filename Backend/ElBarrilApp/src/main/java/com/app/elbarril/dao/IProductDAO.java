package com.app.elbarril.dao;

import org.springframework.data.repository.CrudRepository;

import com.app.elbarril.entity.Product;


public interface IProductDAO extends CrudRepository<Product, Long>{

}
