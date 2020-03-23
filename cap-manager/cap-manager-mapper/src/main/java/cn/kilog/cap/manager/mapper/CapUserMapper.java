package cn.kilog.cap.manager.mapper;

import cn.kilog.cap.manager.pojo.CapUser;
import cn.kilog.cap.manager.pojo.CapUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CapUserMapper {
    int countByExample(CapUserExample example);

    int deleteByExample(CapUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CapUser record);

    int insertSelective(CapUser record);

    List<CapUser> selectByExample(CapUserExample example);

    CapUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CapUser record, @Param("example") CapUserExample example);

    int updateByExample(@Param("record") CapUser record, @Param("example") CapUserExample example);

    int updateByPrimaryKeySelective(CapUser record);

    int updateByPrimaryKey(CapUser record);
}