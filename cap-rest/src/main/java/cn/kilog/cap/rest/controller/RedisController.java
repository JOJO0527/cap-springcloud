package cn.kilog.cap.rest.controller;

import cn.kilog.cap.common.pojo.ResponseResult;
import cn.kilog.cap.rest.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 */
@Controller
@RequestMapping("/cache/sync")
public class RedisController {

	@Autowired
	private RedisService redisService;
	
	@RequestMapping("/content/{contentCid}")
	@ResponseBody
	public ResponseResult contentCacheSync(@PathVariable Long contentCid) {
		ResponseResult result = redisService.syncContent(contentCid);
		return result;
	}
}
