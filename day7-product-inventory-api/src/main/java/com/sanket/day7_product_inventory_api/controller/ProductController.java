package com.sanket.day7_product_inventory_api.controller;


import com.sanket.day7_product_inventory_api.dto.ProductRequest;
import com.sanket.day7_product_inventory_api.dto.ProductResponse;
import com.sanket.day7_product_inventory_api.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private final ProductService svc;

    public ProductController(ProductService svc) {
        this.svc = svc;
    }

    @GetMapping
    public Page<ProductResponse> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(required = false) String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir
    ) {
        return svc.getAll(page, size, sortBy, sortDir);
    }


    @GetMapping("/{id}")
    public ProductResponse getById(@PathVariable Long id){
        return svc.getById(id);
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@Valid @RequestBody ProductRequest req){
        ProductResponse created = svc.create(req);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(created.getId()).toUri();
        return  ResponseEntity.created(location).body(created);
    }

    @PutMapping("{id}")
    public ProductResponse update(@PathVariable Long id, @Valid @RequestBody ProductRequest req){
        return svc.update(id, req);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        svc.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<ProductResponse> searchByName(@RequestParam String name){
        return svc.searchByName(name);
    }

    @GetMapping("/category/{category}")
    public Page<ProductResponse> byCategory(@PathVariable String category,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "20") int size){
        return svc.findByCategory(category, page, size);
    }

    @GetMapping("/lowstock")
    public List<ProductResponse> lowStock(@RequestParam(defaultValue = "10") int threshold){
        return svc.lowStock(threshold);
    }


    @PatchMapping("/{id}/adjust-stock")
    public ProductResponse adjustStock(@PathVariable Long id, @RequestParam int delata){
        return svc.adjustStock(id, delata);
    }
















}
