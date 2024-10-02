package com.works.restcontrollers;

import com.works.entities.Product;
import com.works.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductRestController {

    private final ProductService productService;

    @PostMapping("save")
    public Product save(@Valid @RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("list")
    public List<Product> list() {
        return productService.productList();
    }
}
