package cn.kilog.cap.rest.controller;

import cn.kilog.cap.common.pojo.ResponseResult;
import cn.kilog.cap.common.utils.ExceptionUtil;
import cn.kilog.cap.manager.pojo.CapContent;
import cn.kilog.cap.rest.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 内容管理Controller
 */
@Controller
@RequestMapping("/content")
public class ContentController {

	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/list/{contentCategoryId}")
	@ResponseBody
	public ResponseResult getContentList(@PathVariable Long contentCategoryId) {
		try {
			List<CapContent> list = contentService.getContentList(contentCategoryId);
			return ResponseResult.ok(list);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
}