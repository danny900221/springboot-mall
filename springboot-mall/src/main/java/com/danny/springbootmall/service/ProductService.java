package com.danny.springbootmall.service;

import com.danny.springbootmall.dto.ProductRequest;
import com.danny.springbootmall.model.Product;

public interface ProductService {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId,ProductRequest productRequest);
    void deleteProductById(Integer productId);
}
