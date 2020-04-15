package cn.kilog.cap.portal.service.impl;//package cn.kilog.cap.portal.service.impl;
//
//import cn.kilog.cap.common.pojo.ResponseResult;
//import cn.kilog.cap.portal.pojo.SearchResult;
//import cn.kilog.cap.portal.service.SearchService;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 商品搜索Service
// */
//
//@Service
//public class SearchServiceImpl implements SearchService {
//
//	@Value("${SEARCH_BASE_URL}")
//	private String SEARCH_BASE_URL;
//
//	@Override
//	public SearchResult search(String queryString, int page) {
//		// 调用cap-search的服务
//		//查询参数
//		Map<String, String> param = new HashMap<>();
//		param.put("q", queryString);
//		param.put("page", page + "");
//		try {
//			//调用服务
//			String json = HttpClientUtil.doGet(SEARCH_BASE_URL, param);
//			//把字符串转换成java对象
//			ResponseResult ResponseResult = ResponseResult.formatToPojo(json, SearchResult.class);
//			if (ResponseResult.getStatus() == 200) {
//				SearchResult result = (SearchResult) ResponseResult.getData();
//				return result;
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//}
