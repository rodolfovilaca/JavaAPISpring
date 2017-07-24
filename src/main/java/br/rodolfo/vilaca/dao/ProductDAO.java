package br.rodolfo.vilaca.dao;

import java.util.List;

import br.rodolfo.vilaca.model.Product;

public interface ProductDAO {
	
	public void create(Product product);
	
	public void update(int id, Double price);
	
	public void delete(int id);
	
	public Product findProduct(int id);
	
	public List<Product> findAllProducts();
	
}
