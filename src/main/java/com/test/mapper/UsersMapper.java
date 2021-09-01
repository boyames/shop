package com.test.mapper;

import com.test.pojo.Users;

public interface UsersMapper {

    public int addUser(Users users);

    public int isExistsUname(String uname);

    public Users selectUserByUnameAndUpwd(Users users);
}
