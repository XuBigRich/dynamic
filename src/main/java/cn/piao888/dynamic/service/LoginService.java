package cn.piao888.dynamic.service;


import cn.piao888.dynamic.domain.Role;
import cn.piao888.dynamic.domain.User;

import java.util.List;

public interface LoginService {
    User getUserByName(String userName);

    List<Role> getRoles(Integer uId);

}
