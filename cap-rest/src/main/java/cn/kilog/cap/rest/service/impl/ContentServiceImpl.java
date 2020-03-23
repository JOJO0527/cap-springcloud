//package cn.kilog.cap.rest.service.impl;
//
//import cn.kilog.cap.common.utils.JsonUtils;
//import cn.kilog.cap.manager.mapper.CapContentMapper;
//import cn.kilog.cap.manager.pojo.CapContent;
//import cn.kilog.cap.manager.pojo.CapContentExample;
//import cn.kilog.cap.rest.dao.JedisClient;
//import cn.kilog.cap.rest.service.ContentService;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//
///**
// * 内容管理
// */
//@Service
//public class ContentServiceImpl implements ContentService {
//
//	@Autowired
//	private CapContentMapper contentMapper;
//	@Autowired
//	private JedisClient jedisClient;
//	@Value("${INDEX_CONTENT_REDIS_KEY}")
//	private String INDEX_CONTENT_REDIS_KEY;
//
//
//	@Override
//	public List<CapContent> getContentList(long contentCid) {
//		//从缓存中取内容
//		try {
//			String result = jedisClient.hget(INDEX_CONTENT_REDIS_KEY, contentCid + "");
//			if (!StringUtils.isBlank(result)) {
//				//把字符串转换成list
//				List<CapContent> resultList = JsonUtils.jsonToList(result, CapContent.class);
//				return resultList;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		//根据内容分类id查询内容列表
//		CapContentExample example = new CapContentExample();
//		Criteria criteria = example.createCriteria();
//		criteria.andCategoryIdEqualTo(contentCid);
//		//执行查询
//		List<CapContent> list = contentMapper.selectByExample(example);
//
//		//向缓存中添加内容
//		try {
//			//把list转换成字符串
//			String cacheString = JsonUtils.objectToJson(list);
//			jedisClient.hset(INDEX_CONTENT_REDIS_KEY, contentCid + "", cacheString);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return list;
//	}
//
//}
