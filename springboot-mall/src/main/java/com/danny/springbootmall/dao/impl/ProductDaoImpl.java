package com.danny.springbootmall.dao.impl;

import com.danny.springbootmall.dao.ProductDao;
import com.danny.springbootmall.model.Product;
import com.danny.springbootmall.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public Product getProductById(Integer productId) {
        String sql="SELECT product_id,product_name, category, image_url, price, stock, description," +
                " created_date, last_modified_date " +
                "FROM product where product_id=:productId";

        Map<String,Object> map=new HashMap<>();
        map.put("productId",productId);

        List<Product> productList= namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        if(productList.size()>0){
            System.out.println("有資料");
            return productList.get(0);
        }else {
            System.out.println("沒資料");
            return null;
        }

    }
}
