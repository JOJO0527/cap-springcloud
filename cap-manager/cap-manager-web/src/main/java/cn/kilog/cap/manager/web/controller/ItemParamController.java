package cn.kilog.cap.manager.web.controller;


import cn.kilog.cap.manager.pojo.CapItemParam;
import cn.kilog.cap.manager.service.ItemParamService;
import cn.kilog.cap.common.pojo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商品规格参数模板管理Controller
 */
@Controller
@RequestMapping("/item/param")
public class ItemParamController {

	@Autowired
	private ItemParamService itemParamServiceImpl;

	@RequestMapping("/query/itemcatid/{itemCatId}")
	@ResponseBody
	public ResponseResult getItemParamByCid(@PathVariable Long itemCatId) {
		ResponseResult result = itemParamServiceImpl.getItemParamByCid(itemCatId);
		return result;
	}

	@RequestMapping("/save/{cid}")
	@ResponseBody
	public ResponseResult insertItemParam(@PathVariable Long cid, String paramData) {
		//创建pojo对象
		CapItemParam itemParam = new CapItemParam();
		itemParam.setItemCatId(cid);
		itemParam.setParamData(paramData);
		ResponseResult result = itemParamServiceImpl.insertItemParam(itemParam);
		return result;
	}
}
