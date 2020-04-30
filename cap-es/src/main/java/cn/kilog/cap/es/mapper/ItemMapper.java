package cn.kilog.cap.es.mapper;

import cn.kilog.cap.es.model.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {
    List<Item> getItemList();
}
