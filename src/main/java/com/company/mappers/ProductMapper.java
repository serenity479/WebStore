package com.company.mappers;


import com.company.dto.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper {


    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException { // будет собирать наш объект из результатов запроса

        Product product = new Product();
        product.setId(resultSet.getInt("id"));
        product.setName(resultSet.getString("name"));
        product.setCost(resultSet.getInt("cost"));
        product.setImg(resultSet.getString("img"));
        return product;
    }
}
