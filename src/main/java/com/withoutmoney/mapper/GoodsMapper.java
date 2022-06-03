package com.withoutmoney.mapper;

import com.withoutmoney.entity.Goods;
import com.withoutmoney.enums.Type;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GoodsMapper implements RowMapper<Goods> {

    public Goods mapRow(ResultSet rs, int rowNum) throws SQLException {

        Goods goods = new Goods();

        goods.setId(rs.getInt("id"));
        goods.setUser_id(rs.getInt("user_id"));
        goods.setName(rs.getString("name"));
        goods.setDescription(rs.getString("description"));
        goods.setType(Type.valueOf(rs.getString("type")));
        goods.setPhoto(rs.getString("photo"));

        return goods;
    }
}
