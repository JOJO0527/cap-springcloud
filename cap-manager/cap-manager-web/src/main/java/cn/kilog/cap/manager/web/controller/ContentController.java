package cn.kilog.cap.manager.web.controller;

import cn.kilog.cap.manager.pojo.CapContent;
import cn.kilog.cap.manager.service.ContentService;
import cn.kilog.cap.common.pojo.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 内容管理Controller
 */
@Controller
@RequestMapping("/content")
public class ContentController {

//	@Autowired
	private ContentService contentServiceImpl;

	@RequestMapping("/save")
	@ResponseBody
	public ResponseResult insertContent(CapContent content) {
		ResponseResult result = contentServiceImpl.insertContent(content);
		return result;
	}
}
