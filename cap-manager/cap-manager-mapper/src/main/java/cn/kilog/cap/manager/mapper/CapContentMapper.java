package cn.kilog.cap.manager.mapper;


import cn.kilog.cap.manager.pojo.CapContent;
import cn.kilog.cap.manager.pojo.CapContentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CapContentMapper {
    int countByExample(CapContentExample example);

    int deleteByExample(CapContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CapContent record);

    int insertSelective(CapContent record);

    List<CapContent> selectByExampleWithBLOBs(CapContentExample example);

    List<CapContent> selectByExample(CapContentExample example);

    CapContent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CapContent record, @Param("example") CapContentExample example);

    int updateByExampleWithBLOBs(@Param("record") CapContent record, @Param("example") CapContentExample example);

    int updateByExample(@Param("record") CapContent record, @Param("example") CapContentExample example);

    int updateByPrimaryKeySelective(CapContent record);

    int updateByPrimaryKeyWithBLOBs(CapContent record);

    int updateByPrimaryKey(CapContent record);
}