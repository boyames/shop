package com.test.mapper;

import com.test.pojo.OrderDetail;

import java.util.List;
import java.util.Map;

public interface OrderDetailMapper {

    public List<OrderDetail> selectOrderDetailList(Map<String,Object> map);

    public int addOrderDetailList(Map<String,Object> map);
}
