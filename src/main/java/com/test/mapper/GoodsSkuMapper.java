package com.test.mapper;

import com.test.pojo.GoodsSku;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsSkuMapper {

    public GoodsSku selectGoodsSku(@Param(value = "goodsId") int goodsId, @Param(value = "skuProperties") String skuProperties);

    public List<GoodsSku> selectGoodsSkuByCartId(int cartId);
}
