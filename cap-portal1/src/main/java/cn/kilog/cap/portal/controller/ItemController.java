package cn.kilog.cap.portal.controller;


import cn.kilog.cap.common.pojo.ResponseResult;
import cn.kilog.cap.manager.pojo.CapItem;
import cn.kilog.cap.portal.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品详情页面展示
 */
@RestController
@RequestMapping("item")
public class ItemController {

    @Autowired
    private ItemService itemService;

/*

 //获取商品的详情页面
    @RequestMapping(value = "/{itemId}")
    public String showItem(@PathVariable Long itemId, Model model) {
        ItemInfo item = itemService.getItemById(itemId);
        model.addAttribute("item",item);
        return "item1";
    }
*/



    //获取商品详细信息
    @RequestMapping(value = "/desc/{itemId}")
    @ResponseBody
    public ResponseResult getItemDesc(@PathVariable Long itemId) {
        return ResponseResult.ok(itemService.getItemDescById(itemId));
    }

    //获取商品基本信息
    @RequestMapping(value = "{itemId}")
    @ResponseBody
    public ResponseResult getInfo(@PathVariable Long itemId) {
        return ResponseResult.ok(itemService.getItemById(itemId));
    }
/*
    //获取商品规格参数
//    @RequestMapping(value = "/item/param/{itemId}", produces = MediaType.TEXT_HTML_VALUE + ";charset=utf-8")
    @RequestMapping(value = "/item/param/{itemId}")
    @ResponseBody
    public CapItemParamItem getItemParam(@PathVariable Long itemId) {
        CapItemParamItem itemParamItem = itemService.getItemParam(itemId);
        return itemParamItem;
    }*/



    @RequestMapping("/list")
    public ResponseResult getItemList() {
       return  ResponseResult.ok(itemService.getItemList());
    }
}
