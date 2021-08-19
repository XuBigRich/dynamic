package cn.piao888.dynamic.mapper;

import cn.piao888.dynamic.annotation.DS;
import cn.piao888.dynamic.domain.SysUser;
import cn.piao888.dynamic.enums.DataSourceType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
@DS(DataSourceType.SLAVE)
public interface SysUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysUser record);

    SysUser selectByPrimaryKey(String id);

    List<SysUser> selectAll();

    int updateByPrimaryKey(SysUser record);

    SysUser getUserByName(String username);
}
