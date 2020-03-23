package cn.kilog.cap.manager.web.controller;


import cn.kilog.cap.manager.service.ContentCategoryService;
import cn.kilog.cap.common.pojo.EUTreeNode;
import cn.kilog.cap.common.pojo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 内容分类管理
 */
@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {

	@Autowired
	private ContentCategoryService contentCategoryServiceImpl;

	@RequestMapping("/list")
	@ResponseBody
	public List<EUTreeNode> getContentCatList(@RequestParam(value="id", defaultValue="0")Long parentId) {
		List<EUTreeNode> list = contentCategoryServiceImpl.getCategoryList(parentId);
		return list;
	}

	@RequestMapping("/create")
	@ResponseBody
	public ResponseResult createContentCategory(Long parentId, String name) {
		ResponseResult result = contentCategoryServiceImpl.insertContentCategory(parentId, name);
		return result;
	}
}
