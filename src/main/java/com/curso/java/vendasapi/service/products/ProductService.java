package com.curso.java.vendasapi.service.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.curso.java.vendasapi.model.Product;
import com.curso.java.vendasapi.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.System.*;


@RestController
@RequestMapping("/api/produtos")
@CrossOrigin("*")
public class ProductService {
    @Autowired
    private ProductRepository repository;

    @PostMapping
    public ProductFormRequest saveProduct(@RequestBody ProductFormRequest product) {
        // TODO: process POST request;
        Product entityProduct = product.toModel();
        out.println(entityProduct);

        repository.save(entityProduct);
        return ProductFormRequest.fromModel(entityProduct);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable Long id, @RequestBody ProductFormRequest product) {
        Optional<Product> existiProduct = repository.findById(id);

        if (existiProduct.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Product entity = product.toModel();
        entity.setId(id);
        repository.save(entity);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<ProductFormRequest> getListProduct(){
        return repository.findAll().stream().map( ProductFormRequest::fromModel).collect(Collectors.toList());
    }
}
