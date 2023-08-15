package com.danny.springbootmall.dao;

import com.danny.springbootmall.dto.ProductRequest;
import com.danny.springbootmall.model.Product;

public interface ProductDao {
    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);
}
