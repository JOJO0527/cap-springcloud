package cn.kilog.cap.rest.service;

import cn.kilog.cap.common.pojo.ResponseResult;

public interface RedisService {

	ResponseResult syncContent(long contentCid);
}
