package cn.piao888.dynamic.mapper;

import cn.piao888.dynamic.annotation.DS;
import cn.piao888.dynamic.domain.User;
import cn.piao888.dynamic.enums.DataSourceType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    User selectByPrimaryKey(String id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User getUserByName(String username);
}
