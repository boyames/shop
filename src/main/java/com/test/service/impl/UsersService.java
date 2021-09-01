package com.test.service.impl;

import com.test.mapper.CartMapper;
import com.test.mapper.UsersMapper;
import com.test.pojo.Cart;
import com.test.pojo.Users;
import com.test.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService implements IUsersService {

    @Autowired
    private UsersMapper usersMapper;

    public UsersMapper getUsersMapper() {
        return usersMapper;
    }

    public void setUsersMapper(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @Autowired
    private CartMapper cartMapper;

    //注册
    @Override
    public int reg(Users users) {
        // 1 添加用户到数据库 返回一个用户id
        usersMapper.addUser(users);
        // 2 将用户id组装到cart对象中 添加购物车信息到数据库
        Cart cart = new Cart();
        cart.setUserId(users.getUserId());

        cartMapper.addCart(cart);

        return users.getUserId();

    }

    @Override
    public int isExistsUname(String uname) {
        return usersMapper.isExistsUname(uname);
    }

    @Override
    public Users login(Users users) {
        return usersMapper.selectUserByUnameAndUpwd(users);
    }


}
