//package cn.kilog.cap.portal.controller;
//
//import cn.kilog.cap.manager.pojo.CapOrder;
//import cn.kilog.cap.portal.pojo.CartItem;
//import cn.kilog.cap.portal.service.CartService;
//import cn.kilog.cap.portal.service.OrderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.List;
//
//@Controller
//@RequestMapping("/order")
//public class OrderController {
//
//    @Autowired
//    private CartService cartService;
//
//    @Autowired
//    private OrderService orderService;
//
//    @RequestMapping("/order-cart")
//    public String showOrderCart(HttpServletRequest request, HttpServletResponse response, Model model) {
//        //取购物车商品列表
//        List<CartItem> list = cartService.getCartItemList(request, response);
//        //传递给页面
//        model.addAttribute("cartList", list);
//
//        return "order-cart";
//    }
//
//    @RequestMapping("/list/{userid}")
//    public String showOrder(@PathVariable Long userid, HttpServletRequest request, HttpServletResponse response, Model model) {
//        List<CapOrder> orders = orderService.findOrderByUserid(userid);
//
//        model.addAttribute("orders", orders);
//
//        return "myorder";
//    }
//
//    @RequestMapping(value = "/orderitem/{orderid}" ,produces = MediaType.TEXT_HTML_VALUE + ";charset=utf-8")
//    @ResponseBody
//    public String showOrderitem(@PathVariable Long orderid, HttpServletRequest request, HttpServletResponse response, Model model) {
////        CapOrderItem orderItem = orderService.findOrderitemByOrderid(orderid);
//        String orderItem = orderService.findOrderitemByOrderid(orderid);
////        model.addAttribute("orderItem", orderItem);
////        return "myorder";
//
//        return  orderItem;
//    }
//
//}
