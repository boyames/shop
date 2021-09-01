package com.test.service;

import com.github.pagehelper.PageInfo;
import com.test.pojo.Goods;

import java.util.List;

public interface IGoodsService {

    //根据条件查询商品列表(分页查询)
    public PageInfo<Goods> selectGoodsByWhere(int cid,int pageIndex,int pageSize);

    //根据商品id查询商品的详细信息
    public Goods selectGoodsByGoodsId(int goodsId);
}
