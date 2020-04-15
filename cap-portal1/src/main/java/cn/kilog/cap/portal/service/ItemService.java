package cn.kilog.cap.portal.service;

import cn.kilog.cap.manager.pojo.CapItem;
import cn.kilog.cap.manager.pojo.CapItemDesc;
import cn.kilog.cap.portal.pojo.ItemInfo;

import java.util.List;

public interface ItemService {


//	CapItemParamItem getItemParam(Long itemId);
	ItemInfo getItemById(Long itemId);
    CapItemDesc getItemDescById(Long itemId);
    List<CapItem> getItemList();

}
