package com.shardingsphere.shardingsphere_demo_1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ShardingsphereDemo1ApplicationTests {

    @Autowired
    private DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {

        try{
            Connection connection = dataSource.getConnection();
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection connection = null;
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/sharding_db?serverTimezone=Asia/Shanghai","sharding","sharding");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from t_order");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<String> columnNameList = new ArrayList<String>();
            while (resultSet.next()){
                String columnName = resultSet.getString("order_id");
                columnNameList.add(columnName);
            }
            System.out.println(columnNameList);
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
