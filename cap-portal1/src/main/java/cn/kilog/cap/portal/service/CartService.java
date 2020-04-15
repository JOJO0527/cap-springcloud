package cn.kilog.cap.portal.service;

import cn.kilog.cap.common.pojo.ResponseResult;
import cn.kilog.cap.portal.pojo.CartItem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface CartService {

	ResponseResult addCartItem(long itemId, int num, HttpServletRequest request, HttpServletResponse response);
	List<CartItem> getCartItemList(HttpServletRequest request, HttpServletResponse response);
	ResponseResult deleteCartItem(long itemId, HttpServletRequest request, HttpServletResponse response);
}
