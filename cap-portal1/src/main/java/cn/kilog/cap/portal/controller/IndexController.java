//package cn.kilog.cap.portal.controller;
//
//import cn.kilog.cap.common.utils.CookieUtils;
//import cn.kilog.cap.manager.pojo.CapItem;
//import cn.kilog.cap.manager.pojo.CapUser;
//import cn.kilog.cap.portal.service.ContentService;
//import cn.kilog.cap.portal.service.ItemService;
//import cn.kilog.cap.portal.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.List;
//
//@Controller
//public class IndexController {
//
//	@Autowired
//	private ContentService contentService;
//	@Autowired
//    private ItemService itemService;
//	@Autowired
//    private UserService userService;
//
//
//	@RequestMapping("/index")
//	public String showIndex(HttpServletRequest request, Model model) {
//	    //获取首页轮播图数据（广告）
//		String adJson = contentService.getContentList();
//		model.addAttribute("ad1", adJson);
//        List<CapItem> itemList = itemService.getItemList();
//        model.addAttribute("itemList",itemList);
//        String token = CookieUtils.getCookieValue(request,"TT_TOKEN");
//        CapUser user = userService.getUserByToken(token);
//        model.addAttribute("user",user);
//		return "index";
//	}
//}
