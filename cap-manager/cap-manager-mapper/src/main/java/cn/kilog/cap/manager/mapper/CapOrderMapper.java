package cn.kilog.cap.manager.mapper;


import cn.kilog.cap.manager.pojo.CapOrder;
import cn.kilog.cap.manager.pojo.CapOrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CapOrderMapper {
    int countByExample(CapOrderExample example);

    int deleteByExample(CapOrderExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(CapOrder record);

    int insertSelective(CapOrder record);

    List<CapOrder> selectByExample(CapOrderExample example);

    CapOrder selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") CapOrder record, @Param("example") CapOrderExample example);

    int updateByExample(@Param("record") CapOrder record, @Param("example") CapOrderExample example);

    int updateByPrimaryKeySelective(CapOrder record);

    int updateByPrimaryKey(CapOrder record);
}