package cn.kilog.cap.portal.service;

import cn.kilog.cap.portal.pojo.SearchResult;

public interface SearchService {

	SearchResult search(String queryString, int page);
}
