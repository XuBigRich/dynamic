package cn.piao888.dynamic.service.Impl;

import cn.piao888.dynamic.annotation.DS;
import cn.piao888.dynamic.domain.SysRole;
import cn.piao888.dynamic.domain.SysUser;
import cn.piao888.dynamic.enums.DataSourceType;
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

    @Override
    public SysUser getUserByName(String getMapByName) {
        //模拟数据库查询，正常情况此处是从数据库或者缓存查询。
        return getSysUser(getMapByName);
    }

    /**
     * 模拟数据库查询
     * @param userName
     * @return
     */
    @DS(DataSourceType.SLAVE)
    public SysUser getSysUser(String userName){
        //根据用户名查出用户
        SysUser sysUser=sysUserMapper.getUserByName(userName);
        //根据用户id查出用户所属角色
//        List<SysRole> roles=getRoles();
//        sysUser.setRoleList(roles);
        System.out.println(sysUser.toString());
        return sysUser;
    }
    @DS(DataSourceType.MASTER)
    public List<SysRole> getRoles(){
        List<SysRole> roles= sysRoleMapper.selectRoleBelongByUserId("1");
        System.out.println( roles.get(0).toString());
        return roles;
    }
}
