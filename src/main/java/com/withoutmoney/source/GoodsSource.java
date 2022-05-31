package com.withoutmoney.source;

import com.withoutmoney.entity.Goods;
import com.withoutmoney.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.List;

public class GoodsSource {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GoodsSource(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Goods> getGoodsList() throws SQLException{
        return jdbcTemplate.query("SELECT * FROM goods", new GoodsMapper());
    }

    public Goods getGoodsById(int id) throws SQLException{
        return jdbcTemplate.query("SELECT * FROM goods WHERE id=" + "'" + id + "'", new GoodsMapper())
                .stream().findAny().orElse(null);
    }

    public Goods show(int id) throws SQLException{
        return jdbcTemplate.query("SELECT * FROM goods WHERE id=" + "'" + id + "'", new GoodsMapper())
                .stream().findAny().orElse(null);
    }

    public void save(Goods goods) throws SQLException{
        jdbcTemplate.update("INSERT INTO goods (user, name, description, type)" + "VALUES(?, ?, ?, ?)",
                goods.getUser_id(), goods.getName(), goods.getDescription(),goods.getType());
    }

    public void update(int id,Goods updatedGoods) throws SQLException{
        String type = String.valueOf(updatedGoods.getType());
        jdbcTemplate.update("UPDATE goods SET user=?, name=?, description=?, type=? WHERE id=?", updatedGoods.getUser_id(),
                updatedGoods.getName(), updatedGoods.getDescription(), type, id);
    }

    public void delete(int id) throws SQLException{
        jdbcTemplate.update("DELETE FROM goods WHERE id=" + id);
    }

}
