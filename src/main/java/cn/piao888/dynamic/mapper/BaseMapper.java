package cn.piao888.dynamic.mapper;

import cn.piao888.dynamic.domain.Base;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 许鸿志
 * @since 2021/11/3
 */
@Mapper
public interface BaseMapper {
    Base getBase();
}
