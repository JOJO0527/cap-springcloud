package cn.kilog.cap.manager.service;


import cn.kilog.cap.manager.pojo.CapItem;
import cn.kilog.cap.common.pojo.EUDataGridResult;
import cn.kilog.cap.common.pojo.ResponseResult;

public interface ItemService {

    CapItem getItemById(long itemId);

    EUDataGridResult getItemList(int page, int rows);

    ResponseResult createItem(CapItem item, String desc, String itemParam) throws Exception;
    //ResponseResult deleteItem(long itemId);
}
