package cn.piao888.dynamic.service.Impl;

import cn.piao888.dynamic.annotation.DS;
import cn.piao888.dynamic.datasource.HandlerDataSource;
import cn.piao888.dynamic.domain.Base;
import cn.piao888.dynamic.domain.Role;
import cn.piao888.dynamic.domain.User;
import cn.piao888.dynamic.enums.DataSourceType;
import cn.piao888.dynamic.mapper.BaseMapper;
import cn.piao888.dynamic.mapper.SysRoleMapper;
import cn.piao888.dynamic.mapper.SysUserMapper;
import cn.piao888.dynamic.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private BaseMapper baseMapper;

    /**
     * 根据用户名查出用户
     *
     * @param userName
     * @return
     */
    @Override
    @DS(DataSourceType.MASTER)
    public User getUserByName(String userName) {
        User sysUser = sysUserMapper.getUserByName(userName);
        return sysUser;
    }

    /**
     * 根据用户id查出用户所属角色
     *
     * @param uid 用户id
     * @return
     */

    public List<Role> getRoles(Integer uid) {
        List<Role> roles = sysRoleMapper.selectRoleBelongByUserId(uid);
        Role role = roles.get(1);
        System.out.println(role);
        return roles;
    }

    @Override
    public Base dynamic(String userName) {
        if (userName.equals("1")) {
            HandlerDataSource.putDataSource("MASTER");
        } else {
            HandlerDataSource.putDataSource("SLAVE");
        }
        return baseMapper.getBase();
    }
}
