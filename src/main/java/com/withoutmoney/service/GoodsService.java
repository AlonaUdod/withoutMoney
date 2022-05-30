package com.withoutmoney.service;

import com.withoutmoney.entity.Goods;
import com.withoutmoney.source.GoodsSource;

import java.sql.SQLException;
import java.util.List;

public class GoodsService {

    private final GoodsSource goodsSource;

    public GoodsService(GoodsSource goodsSource) {
        this.goodsSource = goodsSource;
    }

    public List<Goods> getGoodsList() throws SQLException {
        return goodsSource.getGoodsList();
    }

    public Goods getGoodsById(int id) throws SQLException{
        return goodsSource.getGoodsById(id);
    }

    public Goods show(int id) throws SQLException{
        return goodsSource.show(id);
    }

    public void save(Goods goods) throws SQLException{
        goodsSource.save(goods);
    }

    public void update(int id,Goods updatedGoods) throws SQLException{
        goodsSource.update(id, updatedGoods);
    }

    public void delete(int id) throws SQLException{
        goodsSource.delete(id);
    }
}
