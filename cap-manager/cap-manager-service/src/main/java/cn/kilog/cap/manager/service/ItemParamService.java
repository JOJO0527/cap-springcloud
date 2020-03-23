package cn.kilog.cap.manager.service;

import cn.kilog.cap.manager.pojo.CapItemParam;
import cn.kilog.cap.common.pojo.ResponseResult;

public interface ItemParamService {

    ResponseResult getItemParamByCid(long cid);

    ResponseResult insertItemParam(CapItemParam itemParam);
}
