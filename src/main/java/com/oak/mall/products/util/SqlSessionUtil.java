package com.oak.mall.products.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class SqlSessionUtil {
    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            // 加载配置文件， 并创建sqlSessionFactory对象
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //创建sqlSession对象
        return sqlSessionFactory.openSession();
    }
}
