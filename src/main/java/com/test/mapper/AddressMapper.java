package com.test.mapper;

import com.test.pojo.Address;

import java.util.List;

public interface AddressMapper {

    public List<Address> selectAddress(int userId);
    public Address selectAddressByOrderId(int orderId);

}
