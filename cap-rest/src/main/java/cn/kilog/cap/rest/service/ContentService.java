package cn.kilog.cap.rest.service;


import cn.kilog.cap.manager.pojo.CapContent;

import java.util.List;

public interface ContentService {

	List<CapContent> getContentList(long contentCid);
}
