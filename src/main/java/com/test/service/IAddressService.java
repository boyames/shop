package com.test.service;

import com.test.pojo.Address;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IAddressService {

    public List<Address> selectAddress(int userId);

    public Address selectAddressByOrderId(int orderId);
}
