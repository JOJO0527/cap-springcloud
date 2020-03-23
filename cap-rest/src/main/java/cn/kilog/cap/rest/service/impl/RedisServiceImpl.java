package cn.kilog.cap.rest.service.impl;

import cn.kilog.cap.common.pojo.ResponseResult;
import cn.kilog.cap.common.utils.ExceptionUtil;
import cn.kilog.cap.rest.dao.JedisClient;
import cn.kilog.cap.rest.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {

	@Autowired
	private JedisClient jedisClient;
	
	@Value("${INDEX_CONTENT_REDIS_KEY}")
	private String INDEX_CONTENT_REDIS_KEY;
	
	@Override
	public ResponseResult syncContent(long contentCid) {
		try {
			jedisClient.hdel(INDEX_CONTENT_REDIS_KEY, contentCid + "");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return ResponseResult.ok();
	}

}
