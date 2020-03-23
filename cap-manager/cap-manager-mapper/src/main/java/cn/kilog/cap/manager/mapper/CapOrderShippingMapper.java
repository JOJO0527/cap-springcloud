package cn.kilog.cap.manager.mapper;

import cn.kilog.cap.manager.pojo.CapOrderShipping;
import cn.kilog.cap.manager.pojo.CapOrderShippingExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CapOrderShippingMapper {
    int countByExample(CapOrderShippingExample example);

    int deleteByExample(CapOrderShippingExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(CapOrderShipping record);

    int insertSelective(CapOrderShipping record);

    List<CapOrderShipping> selectByExample(CapOrderShippingExample example);

    CapOrderShipping selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") CapOrderShipping record, @Param("example") CapOrderShippingExample example);

    int updateByExample(@Param("record") CapOrderShipping record, @Param("example") CapOrderShippingExample example);

    int updateByPrimaryKeySelective(CapOrderShipping record);

    int updateByPrimaryKey(CapOrderShipping record);
}