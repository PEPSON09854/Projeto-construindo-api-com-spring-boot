package br.com.projeto.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.projeto.api.models.ProductModel;
import br.com.projeto.api.models.ResponseModel;
import br.com.projeto.api.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productReposytory;

    @Autowired
    private ResponseModel rm;

    // Metodo que listas todos os produtos
    public Iterable<ProductModel> listProduct() {
        return productReposytory.findAll();
    }

    // Metodo para cadastrar ou atualizar produtos
    public ResponseEntity<?> createProduct(ProductModel pm, String action) {
        if (pm.getName().equals("")) {
            rm.setMessage("O nome do producto é obrigatório!");
            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);
        } else if (pm.getPrice() == 0) {
            rm.setMessage("O preço do producto é obrigatório!");
            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);
        } else if (pm.getDescription().equals("")) {
            rm.setMessage("A descrição do producto é obrigatório!");
            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);
        } else if (action.equals("cadastrar")) {
            return new ResponseEntity<ProductModel>(productReposytory.save(pm), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<ProductModel>(productReposytory.save(pm), HttpStatus.OK);
        }
    }

    // Metodo que remove um produto do banco
    public ResponseEntity<ResponseModel> deleteproduct(Long id) {
        productReposytory.deleteById(id);

        rm.setMessage("produto removido com sucesso!");
        return new ResponseEntity<ResponseModel>(rm, HttpStatus.OK);
    }
}
