package cn.kilog.cap.portal.service.impl;//package cn.kilog.cap.portal.service.impl;
//
//import cn.kilog.cap.common.pojo.ResponseResult;
//import cn.kilog.cap.common.utils.JsonUtils;
//import cn.kilog.cap.manager.pojo.CapOrder;
//import cn.kilog.cap.portal.pojo.Order;
//import cn.kilog.cap.portal.service.OrderService;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
///**
// * 订单处理Service
// */
//@Service
//public class OrderServiceImpl implements OrderService {
//
//	@Value("${ORDER_BASE_URL}")
//	private String ORDER_BASE_URL;
//	@Value("${ORDER_CREATE_URL}")
//	private String ORDER_CREATE_URL;
//    @Value("${ORDER_LIST_URL}")
//    private String ORDER_LIST_URL;
//    @Value("${ORDER_ITEM_URL}")
//    private String ORDER_ITEM_URL;
//
//
//	@Override
//	public String createOrder(Order order) {
//		//调用创建订单服务之前补全用户信息。
//		//从cookie中后取TT_TOKEN的内容，根据token调用sso系统的服务根据token换取用户信息。
//
//		//调用cap-order的服务提交订单。
//		String json = HttpClientUtil.doPostJson(ORDER_BASE_URL + ORDER_CREATE_URL, JsonUtils.objectToJson(order));
//		//把json转换成ResponseResult
//		ResponseResult ResponseResult = ResponseResult.format(json);
//		if (ResponseResult.getStatus() == 200) {
//			Object orderId = ResponseResult.getData();
//			return orderId.toString();
//		}
//		return "";
//	}
//
//    @Override
//    public List<CapOrder> findOrderByUserid(Long userid) {
//        String json = HttpClientUtil.doPostJson(ORDER_BASE_URL + ORDER_LIST_URL +userid , JsonUtils.objectToJson(userid));
//        ResponseResult ResponseResult = ResponseResult.format(json);
//        if (ResponseResult.getStatus() == 200) {
//            List<CapOrder> orders = (List<CapOrder>)ResponseResult.getData();
//            return orders;
//        }
//        return null;
//    }
//
//    @Override
//    public String findOrderitemByOrderid(Long orderid) {
//        String json = HttpClientUtil.doPostJson(ORDER_BASE_URL + ORDER_ITEM_URL +orderid , JsonUtils.objectToJson(orderid));
////        ResponseResult ResponseResult = ResponseResult.formatToPojo(json,CapOrderItem.class);
////        if (ResponseResult.getStatus() == 200) {
////            CapOrderItem orderitem = (CapOrderItem)ResponseResult.getData();
////            return orderitem;
////        }
//        return json;
//    }
//
//}