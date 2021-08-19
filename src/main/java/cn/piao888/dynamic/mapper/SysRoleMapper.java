package cn.piao888.dynamic.mapper;

import cn.piao888.dynamic.annotation.DS;
import cn.piao888.dynamic.domain.Role;
import cn.piao888.dynamic.enums.DataSourceType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper

public interface SysRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Role record);

    int updateByPrimaryKey(Role record);
    @DS(DataSourceType.SLAVE)
    List<Role> selectRoleBelongByUserId(Integer userId);
}
