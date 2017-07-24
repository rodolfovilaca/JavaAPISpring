package br.rodolfo.vilaca.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import br.rodolfo.vilaca.dao.ProductDAO;
import br.rodolfo.vilaca.dto.Product;
import br.rodolfo.vilaca.webservice.ProductWS;

public class ProductWSImpl implements ProductWS {
	ProductDAO dao;
	public ProductDAO getDao() {
		return dao;
	}

	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}

	@Override
	public Response add(Product product) {
		br.rodolfo.vilaca.model.Product productModel = new br.rodolfo.vilaca.model.Product(product.getId(),product.getName(),
				product.getPrice(),product.getDescription(),product.getQuantity());
		dao.create(productModel);
		return Response.ok().build();
	}

	@Override
	public Response update(Product product) {
		dao.update(product.getId(), product.getPrice());
		return Response.ok().build();
	}

	@Override
	public Response delete(int id) {
		dao.delete(id);
		return Response.ok().build();
	}

	@Override
	public Response find(int id) {
		br.rodolfo.vilaca.model.Product productModel = dao.findProduct(id);
		Product product = new Product(productModel.getId(), productModel.getName(),productModel.getPrice(),productModel.getDescription(),
				productModel.getQuantity());
		return Response.ok(product)
//				.header("Access-Control-Allow-Origin", "*")
//	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
//	            .header("Access-Control-Allow-Credentials", "true")
//	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
//	            .header("Access-Control-Max-Age", "1209600")
	            .build();
	}

	@Override
	public Response findAll() {
		List<br.rodolfo.vilaca.model.Product> table = dao.findAllProducts();
		List<Product> productList = new ArrayList<>();
		for (br.rodolfo.vilaca.model.Product productModel : table){
			Product product = new Product(productModel.getId(), productModel.getName(),productModel.getPrice(),productModel.getDescription(),
					productModel.getQuantity());
			productList.add(product);
		}
		GenericEntity<List<Product>> list = new GenericEntity<List<Product>>(productList) {};
		return Response.ok(list)
//				.header("Access-Control-Allow-Origin", "*")
//	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
//	            .header("Access-Control-Allow-Credentials", "true")
//	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
//	            .header("Access-Control-Max-Age", "1209600")
	            .build();
	}

}
