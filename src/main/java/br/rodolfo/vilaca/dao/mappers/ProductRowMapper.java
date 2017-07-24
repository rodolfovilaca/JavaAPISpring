package br.rodolfo.vilaca.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.rodolfo.vilaca.model.Product;

public class ProductRowMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
		Product product = new Product(resultSet.getInt(1),resultSet.getString(2),resultSet.getDouble(3),
					resultSet.getString(4),resultSet.getInt(5));

		return product;
	}
}
