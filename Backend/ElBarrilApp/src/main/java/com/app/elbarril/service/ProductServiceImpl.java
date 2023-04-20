package com.app.elbarril.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.elbarril.dao.IProductDAO;
import com.app.elbarril.entity.Product;


@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private IProductDAO productDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<Product> findAll() {
		return (List<Product>)productDAO.findAll();
	}



	@Override
	@Transactional
	public Product findById(Long id) {
		return productDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Product save(Product product) {
		return productDAO.save(product);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		productDAO.deleteById(id);
		
	}

}
