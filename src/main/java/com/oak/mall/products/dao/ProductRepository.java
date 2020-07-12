package com.oak.mall.products.dao;

import com.oak.mall.products.entity.Product;

public interface ProductRepository {

    Product findByProductId(Integer id);
}
