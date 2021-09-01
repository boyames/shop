package com.test.service;

import com.test.pojo.Users;

public interface IUsersService {

    public int reg(Users users);

    public int isExistsUname(String uname);

    public Users login(Users users);
}
