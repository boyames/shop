package com.test.service.impl;

import com.test.mapper.AddressMapper;
import com.test.pojo.Address;
import com.test.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressService implements IAddressService {

    @Autowired
    private AddressMapper addressMapper;

    public AddressMapper getAddressMapper() {
        return addressMapper;
    }

    public void setAddressMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    @Override
    public List<Address> selectAddress(int userId) {
        return addressMapper.selectAddress(userId);
    }

    @Override
    public Address selectAddressByOrderId(int orderId) {
        return addressMapper.selectAddressByOrderId(orderId);
    }
}
