package cn.kilog.cap.manager.mapper;


import cn.kilog.cap.manager.pojo.CapOrderItem;
import cn.kilog.cap.manager.pojo.CapOrderItemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CapOrderItemMapper {
    int countByExample(CapOrderItemExample example);

    int deleteByExample(CapOrderItemExample example);

    int deleteByPrimaryKey(String id);

    int insert(CapOrderItem record);

    int insertSelective(CapOrderItem record);

    List<CapOrderItem> selectByExample(CapOrderItemExample example);

    CapOrderItem selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CapOrderItem record, @Param("example") CapOrderItemExample example);

    int updateByExample(@Param("record") CapOrderItem record, @Param("example") CapOrderItemExample example);

    int updateByPrimaryKeySelective(CapOrderItem record);

    int updateByPrimaryKey(CapOrderItem record);
}