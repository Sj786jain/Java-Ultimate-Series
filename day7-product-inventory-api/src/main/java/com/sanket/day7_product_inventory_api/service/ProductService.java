package com.sanket.day7_product_inventory_api.service;

import com.sanket.day7_product_inventory_api.dto.ProductRequest;
import com.sanket.day7_product_inventory_api.dto.ProductResponse;
import com.sanket.day7_product_inventory_api.entity.Product;
import com.sanket.day7_product_inventory_api.exception.ResourceNotFoundException;
import com.sanket.day7_product_inventory_api.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }


    private ProductResponse mapToResponse(Product p){
        ProductResponse r= new ProductResponse();
        r.setId(p.getId());
        r.setName(p.getName());
        r.setDescription(p.getDescription());
        r.setPrice(p.getPrice());
        r.setQuantity(p.getQuantity());
        r.setCategory(p.getCategory());
        r.setCreatedAt(p.getCreatedAt());
        r.setUpdatedAt(p.getUpdatedAt());
        return r;
    }

    private Product mapFromRequest(ProductRequest req) {
        Product p = new Product();
        p.setName(req.getName());
        p.setDescription(req.getDescription());
        p.setPrice(req.getPrice());
        p.setQuantity(req.getQuantity());
        p.setCategory(req.getCategory());
        return p;
    }

    public Page<ProductResponse> getAll(int page, int size, String sortBy, String sortDir){
        Sort sort = Sort.by(sortBy == null ? "id" : sortBy);
        sort = "desc".equalsIgnoreCase(sortDir) ? sort.descending() : sort.ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Product> ppage = repo.findAll(pageable);
        return ppage.map(this::mapToResponse);
    }

    public ProductResponse getById(Long id){
        Product p = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
        return mapToResponse(p);
    }

    public ProductResponse create(ProductRequest req){
        Product p = mapFromRequest(req);
        Product saved = repo.save(p);
        return mapToResponse(saved);
    }

    public ProductResponse update(Long id, ProductRequest req){
        Product p = repo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Product", "id", id));
        p.setName(req.getName());
        p.setDescription(req.getDescription());
        p.setPrice(req.getPrice());
        p.setQuantity(req.getQuantity());
        p.setCategory(req.getCategory());
        Product updated = repo.save(p);
        return mapToResponse(updated);
    }

    public void delete(Long id){
        if(!repo.existsById(id)){
            throw  new ResourceNotFoundException("Product", "id", id);
        }
        repo.deleteById(id);
    }

    public List<ProductResponse> searchByName(String name){
        return repo.findByNameContainingIgnoreCase(name).stream()
                .map(this::mapToResponse).collect(Collectors.toList());
    }

    public Page<ProductResponse> findByCategory(String category, int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> p = repo.findByCategoryIgnoreCase(category, pageable);
        return p.map(this::mapToResponse);
    }

    public List<ProductResponse> lowStock(int threshold){
        return repo.findByQuantityLessThanEqual(threshold).stream()
                .map(this::mapToResponse).collect(Collectors.toList());

    }

    @Transactional
    public ProductResponse adjustStock(Long id, int delta){
        Product p = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
        int newQty = p.getQuantity() + delta;
        if(newQty < 0){
            throw new IllegalArgumentException("Resulting quantity cannot be negative");
        }
        p.setQuantity(newQty);
        Product updated = repo.save(p);
        return mapToResponse(updated);
    }


}
