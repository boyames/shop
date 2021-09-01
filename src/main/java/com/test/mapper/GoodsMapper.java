package com.test.mapper;

import com.test.pojo.Goods;

import java.util.List;

public interface GoodsMapper {

    public List<Goods> selectGoodsByCid(int cid);

    public Goods selectGoodsByGoodsId(int goodsId);

}
