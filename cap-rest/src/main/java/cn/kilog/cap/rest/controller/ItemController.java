package cn.kilog.cap.rest.controller;

import cn.kilog.cap.common.pojo.ResponseResult;
import cn.kilog.cap.rest.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商品信息Controller
 */
@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;
	//取商品基本信息
	@RequestMapping("/info/{itemId}")
	@ResponseBody
	public ResponseResult getItemBaseInfo(@PathVariable Long itemId) {
		ResponseResult result = itemService.getItemBaseInfo(itemId);
		return result;
	}
	//取商品详细信息
	@RequestMapping("/desc/{itemId}")
	@ResponseBody
	public ResponseResult getItemDesc(@PathVariable Long itemId) {
		ResponseResult result = itemService.getItemDesc(itemId);
		return result;
	}
	//取商品规格信息
	@RequestMapping("/param/{itemId}")
	@ResponseBody
	public ResponseResult getItemParam(@PathVariable Long itemId) {
		ResponseResult result = itemService.getItemParam(itemId);
		return result;
	}
	//取商品竞标表
	@RequestMapping("/record/{itemId}")
	@ResponseBody
	public ResponseResult getItemRecord(@PathVariable Long itemId) {
		ResponseResult result = itemService.getItemRecord(itemId);
		return  result;
	}
	//取过期商品
	@RequestMapping("/overtime")
	@ResponseBody
	public ResponseResult getOvertimeItem() {
		ResponseResult result = itemService.getOvertimeItem();
		return  result;
	}
    @RequestMapping("/list")
    @ResponseBody
    public ResponseResult getItemList() {
        ResponseResult result = itemService.getItemList();
        return  result;
    }


}
