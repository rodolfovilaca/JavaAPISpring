package br.rodolfo.vilaca.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import br.rodolfo.vilaca.dao.mappers.ProductRowMapper;
import br.rodolfo.vilaca.model.Product;

public class ProductDAOImpl implements ProductDAO {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void create(Product product) {
		jdbcTemplate.update("insert into Product value(" + product.getId() + ",'" + product.getName() + "',"
				+ product.getPrice() + ",'" + product.getDescription() + "'," + product.getQuantity() + ")");
	}

	@Override
	public void update(int id, Double price) {
		jdbcTemplate.update("update Product set price =" + price + " where id=" + id);
	}

	@Override
	public void delete(int id) {
		jdbcTemplate.update("delete from Product where id=" + id);
	}

	@Override
	public Product findProduct(int id) {

		return jdbcTemplate.queryForObject("select * from Product where id=" + id, new ProductRowMapper());
	}

	@Override
	public List<Product> findAllProducts() {
		return jdbcTemplate.query("SELECT * FROM Product", new ProductRowMapper());
	}

}
