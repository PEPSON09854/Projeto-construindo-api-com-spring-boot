package br.com.projeto.api.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.projeto.api.models.ProductModel;

public interface ProductRepository extends CrudRepository<ProductModel, Long> {

}
