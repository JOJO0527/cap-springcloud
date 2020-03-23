package cn.kilog.cap.manager.web.controller;

import cn.kilog.cap.manager.service.ItemCatService;
import cn.kilog.cap.common.pojo.EUTreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 商品分类管理controller
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatServiceImpl;

	@RequestMapping("/list")
	@ResponseBody
	private List<EUTreeNode> getCatList(@RequestParam(value="id",defaultValue="0")Long parentId) {
		List<EUTreeNode> list = itemCatServiceImpl.getCatList(parentId);
		return list;
	}
}
