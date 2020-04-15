package cn.kilog.cap.portal.service.impl;//package cn.kilog.cap.portal.service.impl;
//
//import cn.kilog.cap.common.pojo.ResponseResult;
//import cn.kilog.cap.common.utils.JsonUtils;
//import cn.kilog.cap.manager.pojo.CapContent;
//import cn.kilog.cap.portal.service.ContentService;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * 调用服务层服务，查询内容列表
// */
//@Service
//public class ContentServiceImpl implements ContentService {
//
//	@Value("${REST_BASE_URL}")
//	private String REST_BASE_URL;
//	@Value("${REST_INDEX_AD_URL}")
//	private String REST_INDEX_AD_URL;
//
//	@Override
//	public String getContentList() {
//		//调用服务层的服务
//		String result = HttpClientUtil.doGet(REST_BASE_URL + REST_INDEX_AD_URL);
//		//把字符串转换成ResponseResult
//		try {
//			ResponseResult ResponseResult = ResponseResult.formatToList(result, CapContent.class);
//			//取内容列表
//			List<CapContent> list = (List<CapContent>) ResponseResult.getData();
//			List<Map> resultList = new ArrayList<>();
// 			//创建一个jsp页码要求的pojo列表
//			for (CapContent capContent : list) {
//				Map map = new HashMap<>();
//				map.put("src", capContent.getPic());
//				map.put("height", 240);
//				map.put("width", 670);
//				map.put("srcB", capContent.getPic2());
//				map.put("widthB", 550);
//				map.put("heightB", 240);
//				map.put("href", capContent.getUrl());
//				map.put("alt", capContent.getSubTitle());
//				resultList.add(map);
//			}
//			return JsonUtils.objectToJson(resultList);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return null;
//	}
//
//}
