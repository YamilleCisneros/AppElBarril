package com.app.elbarril.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.app.elbarril.entity.Product;
import com.app.elbarril.service.IProductService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	@GetMapping("/products")
	public List<Product> index(){
		return productService.findAll();
	}
	
	@GetMapping("/products/{id}")
	public Product show(@PathVariable Long id) {
		return productService.findById(id);
	}
	
	@PostMapping("/products")
	public Product create(@RequestBody Product product) {
		return productService.save(product);
	}
	
	@PutMapping("/productos/{id}")
	public Product update(@RequestBody Product product, @PathVariable Long id) {
		Product p = productService.findById(id);
		p.setCode(product.getCode());
		p.setName(product.getName());
		p.setDescription(product.getDescription());
		p.setPrice(product.getPrice());
		p.setCategory(product.getCategory());
		p.setImage(product.getImage());
		p.setRating(product.getRating());

		return productService.save(p);
	}
	
	@DeleteMapping("/products/{id}")
	public void delete(@PathVariable Long id) {
		productService.delete(id);
	}
	
	

}
