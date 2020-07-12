package com.oak.mall.products.dao.impl;

import com.oak.mall.products.dao.ProductRepository;
import com.oak.mall.products.entity.Product;
import com.oak.mall.products.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class ProductMapper implements ProductRepository {

    @Override
    public Product findByProductId(Integer id) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        try {
            //执行select语句， 将ResultSet映射成对象返回
            Product product = sqlSession.selectOne("findByProductId", id);
            return product;
        } finally {
            sqlSession.close();
        }

    }
}
