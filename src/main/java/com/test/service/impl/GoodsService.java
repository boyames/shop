package com.test.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.mapper.GoodsMapper;
import com.test.pojo.Goods;
import com.test.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService implements IGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    public GoodsMapper getGoodsMapper() {
        return goodsMapper;
    }

    public void setGoodsMapper(GoodsMapper goodsMapper) {
        this.goodsMapper = goodsMapper;
    }

    //改成分页查询
    @Override
    public PageInfo<Goods> selectGoodsByWhere(int cid,int pageIndex,int pageSize) {

        //设置开始查询的位置，以及查询多少条记录
        PageHelper.startPage(pageIndex,pageSize);
        //查询当前页数据
        List<Goods> goodsList=goodsMapper.selectGoodsByCid(cid);
        //组装成page对象
        PageInfo<Goods> pageInfo=new PageInfo<>(goodsList);

        return pageInfo;
    }

    //根据商品id查询商品详细信息
    @Override
    public Goods selectGoodsByGoodsId(int goodsId) {

        return goodsMapper.selectGoodsByGoodsId(goodsId);

    }
}
