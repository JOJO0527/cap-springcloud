package cn.kilog.cap.manager.service.impl;


import cn.kilog.cap.manager.service.ContentService;
import cn.kilog.cap.manager.mapper.CapContentMapper;
import cn.kilog.cap.manager.pojo.CapContent;
import cn.kilog.cap.common.pojo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 内容管理
 */
@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private CapContentMapper contentMapper;
	@Value("${REST.BASE.URL}")
	private String REST_BASE_URL;
	@Value("${REST.CONTENT.SYNC.URL}")
	private String REST_CONTENT_SYNC_URL;


	@Override
	public ResponseResult insertContent(CapContent content) {
		//补全pojo内容
		content.setCreated(new Date());
		content.setUpdated(new Date());
		contentMapper.insert(content);

		//添加缓存同步逻辑
//		try {
//			HttpClientUtil.doGet(REST_BASE_URL + REST_CONTENT_SYNC_URL + content.getCategoryId());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		return ResponseResult.ok();
	}

}
