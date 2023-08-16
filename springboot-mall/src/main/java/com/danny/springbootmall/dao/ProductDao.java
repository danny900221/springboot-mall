package com.danny.springbootmall.dao;

import com.danny.springbootmall.constant.ProductCategory;
import com.danny.springbootmall.dto.ProductRequest;
import com.danny.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getProducts(ProductCategory category,String search);
    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);
    void updateProduct(Integer productId,ProductRequest productRequest);
    void deleteProductById(Integer productId);
}
