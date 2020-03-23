package cn.kilog.cap.manager.mapper;


import cn.kilog.cap.manager.pojo.CapItem;
import cn.kilog.cap.manager.pojo.CapItemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CapItemMapper {
    int countByExample(CapItemExample example);

    int deleteByExample(CapItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CapItem record);

    int insertSelective(CapItem record);

    List<CapItem> selectByExample(CapItemExample example);

    CapItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CapItem record, @Param("example") CapItemExample example);

    int updateByExample(@Param("record") CapItem record, @Param("example") CapItemExample example);

    int updateByPrimaryKeySelective(CapItem record);

    int updateByPrimaryKey(CapItem record);
}