package cn.kilog.cap.portal.service.impl;//package cn.kilog.cap.portal.service.impl;
//
//import cn.kilog.cap.common.pojo.ResponseResult;
//import cn.kilog.cap.common.utils.CookieUtils;
//import cn.kilog.cap.common.utils.JsonUtils;
//import cn.kilog.cap.manager.pojo.CapItem;
//import cn.kilog.cap.portal.pojo.CartItem;
//import cn.kilog.cap.portal.service.CartService;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 购物车Service
// */
//@Service
//public class CartServiceImpl implements CartService{
//
//	@Value("${REST_BASE_URL}")
//	private String REST_BASE_URL;
//	@Value("${ITME_INFO_URL}")
//	private String ITME_INFO_URL;
//
//
//	/**
//	 * 添加购物车商品
//	 * <p>Title: addCartItem</p>
//	 * <p>Description: </p>
//	 * @param itemId
//	 * @param num
//	 * @return
//	 * @see cn.kilog.cap.portal.service.CartService#addCartItem(long, int)
//	 */
//	@Override
//	public ResponseResult addCartItem(long itemId, int num,
//			HttpServletRequest request, HttpServletResponse response) {
//		//取商品信息
//		CartItem cartItem = null;
//		//取购物车商品列表
//		List<CartItem> itemList = getCartItemList(request);
//		//判断购物车商品列表中是否存在此商品
//		for (CartItem cItem : itemList) {
//			//如果存在此商品
//			if (cItem.getId() == itemId) {
//				//增加商品数量
//				cItem.setNum(cItem.getNum() + num);
//				cartItem = cItem;
//				break;
//			}
//		}
//		if (cartItem == null) {
//			cartItem = new CartItem();
//			//根据商品id查询商品基本信息。
//			String json = HttpClientUtil.doGet(REST_BASE_URL + ITME_INFO_URL + itemId);
//			//把json转换成java对象
//			ResponseResult ResponseResult = ResponseResult.formatToPojo(json, CapItem.class);
//			if (ResponseResult.getStatus() == 200) {
//				CapItem item = (CapItem) ResponseResult.getData();
//				cartItem.setId(item.getId());
//				cartItem.setTitle(item.getTitle());
//				cartItem.setImage(item.getImage() == null ? "":item.getImage().split(",")[0]);
//				cartItem.setNum(num);
//				cartItem.setPrice(item.getPrice());
//			}
//			//添加到购物车列表
//			itemList.add(cartItem);
//		}
//		//把购物车列表写入cookie
//		CookieUtils.setCookie(request, response, "TT_CART", JsonUtils.objectToJson(itemList), true);
//
//		return ResponseResult.ok();
//	}
//	/**
//	 * 从cookie中取商品列表
//	 * <p>Title: getCartItemList</p>
//	 * <p>Description: </p>
//	 * @return
//	 */
//	private List<CartItem> getCartItemList(HttpServletRequest request) {
//		//从cookie中取商品列表
//		String cartJson = CookieUtils.getCookieValue(request, "TT_CART", true);
//		if (cartJson == null) {
//			return new ArrayList<>();
//		}
//		//把json转换成商品列表
//		try {
//			List<CartItem> list = JsonUtils.jsonToList(cartJson, CartItem.class);
//			return list;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return new ArrayList<>();
//	}
//
//
//	@Override
//	public List<CartItem> getCartItemList(HttpServletRequest request, HttpServletResponse response) {
//		List<CartItem> itemList = getCartItemList(request);
//		return itemList;
//	}
//	/**
//	 * 删除购物车商品
//	 * <p>Title: deleteCartItem</p>
//	 * <p>Description: </p>
//	 * @param itemId
//	 * @return
//	 * @see cn.kilog.cap.portal.service.CartService#deleteCartItem(long)
//	 */
//	@Override
//	public ResponseResult deleteCartItem(long itemId, HttpServletRequest request, HttpServletResponse response) {
//		//从cookie中取购物车商品列表
//		List<CartItem> itemList = getCartItemList(request);
//		//从列表中找到此商品
//		for (CartItem cartItem : itemList) {
//			if (cartItem.getId() == itemId) {
//				itemList.remove(cartItem);
//				break;
//			}
//
//		}
//		//把购物车列表重新写入cookie
//		CookieUtils.setCookie(request, response, "TT_CART", JsonUtils.objectToJson(itemList), true);
//
//		return ResponseResult.ok();
//	}
//
//
//
//}
