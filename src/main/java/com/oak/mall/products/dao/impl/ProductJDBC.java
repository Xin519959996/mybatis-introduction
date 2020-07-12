package com.oak.mall.products.dao.impl;

import com.oak.mall.products.dao.ProductRepository;
import com.oak.mall.products.entity.Product;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductJDBC implements ProductRepository {
    @Override
    public Product findByProductId(Integer id) {
        return getList(id).get(0);
    }

    private List<Product> getList(Integer paramId) {
        List<Product> products = null;

        try {
            DriverManager.deregisterDriver(new com.mysql.jdbc.Driver());
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/oak", "root", "123456");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM system_product where product_id = ?");

            preparedStatement.setInt(1, paramId);
            ResultSet resultSet = preparedStatement.executeQuery();
            products = new ArrayList<>();
            Product product;
            while (resultSet.next()){
                int productId = resultSet.getInt("product_id");
                String name = resultSet.getString("product_name");
                BigDecimal price = resultSet.getBigDecimal("product_price");

                product = new Product();
                product.setProductId(productId);
                product.setProductName(name);
                product.setProductPrice(price);

                products.add(product);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return products;
    }
}
