package cn.kilog.cap.rest.service;


import cn.kilog.cap.common.pojo.ResponseResult;

public interface ItemService {

	ResponseResult getItemBaseInfo(long itemId);
	ResponseResult getItemDesc(long itemId);
	ResponseResult getItemParam(long itemId);
	ResponseResult getItemRecord(long itemId);
	ResponseResult getOvertimeItem();
	ResponseResult getItemList();
}
