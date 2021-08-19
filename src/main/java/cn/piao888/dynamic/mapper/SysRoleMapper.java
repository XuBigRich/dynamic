package cn.piao888.dynamic.mapper;

import cn.piao888.dynamic.annotation.DS;
import cn.piao888.dynamic.domain.SysRole;
import cn.piao888.dynamic.enums.DataSourceType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
@DS(DataSourceType.MASTER)
public interface SysRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysRole record);

    int updateByPrimaryKey(SysRole record);

    List<SysRole> selectRoleBelongByUserId(String userId);
}
