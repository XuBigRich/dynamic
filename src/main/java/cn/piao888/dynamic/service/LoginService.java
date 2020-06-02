package cn.piao888.dynamic.service;


import cn.piao888.dynamic.domain.SysRole;
import cn.piao888.dynamic.domain.SysUser;

import java.util.List;

public interface LoginService {
     SysUser getUserByName(String getMapByName);
     List<SysRole> getRoles();
     SysUser getSysUser(String userName);
}
