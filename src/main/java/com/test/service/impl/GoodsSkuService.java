package com.test.service.impl;

import com.test.mapper.GoodsSkuMapper;
import com.test.pojo.GoodsSku;
import com.test.service.IGoodsSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsSkuService implements IGoodsSkuService {

    @Autowired
    private GoodsSkuMapper goodsSkuMapper;
    @Override
    public GoodsSku getGoodsSku(int goodsId, String sku_properties) {
        return goodsSkuMapper.selectGoodsSku(goodsId,sku_properties);
    }
}
