package br.com.projeto.api.controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.models.ProductModel;
import br.com.projeto.api.models.ResponseModel;
import br.com.projeto.api.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService ps;

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseModel> removeProduct(@PathVariable Long id) {
        return ps.deleteproduct(id);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateProduct(@RequestBody ProductModel pm) {
        return ps.createProduct(pm, "atualizar");

    }

    @PostMapping("/register")
    public ResponseEntity<?> registerProduct(@RequestBody ProductModel pm) {
        return ps.createProduct(pm, "cadastrar");

    }

    @GetMapping("/products")
    public Iterable<ProductModel> getProduct() {
        return ps.listProduct();
    }

    @GetMapping("/")
    public String rota() {
        return "rota blz!";
    }

}
