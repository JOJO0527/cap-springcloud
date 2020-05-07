package cn.kilog.cap.order.controller;

import cn.kilog.cap.common.pojo.ResponseResult;
import cn.kilog.cap.manager.pojo.CapOrderShipping;
import cn.kilog.cap.order.model.CartItem;
import cn.kilog.cap.order.service.CartService;
import cn.kilog.cap.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("order")
@Slf4j
@PreAuthorize("hasAnyAuthority('user')")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private CartService cartService;

    @PostMapping("/cart/{itemId}/{num}")
    public ResponseResult addCart(
            HttpServletRequest request, HttpServletResponse response,
            @PathVariable("itemId") Long itemId, @PathVariable("num") Integer number){
        String userId = request.getHeader("userId");
        if (StringUtils.isEmpty(userId))
            userId = "095f95adc9834328a4edbe4b70a731c8";
        return cartService.addCart(userId,itemId ,number);
    }

    @GetMapping("/cart/list")
    public ResponseResult getCart(HttpServletRequest request, HttpServletResponse response){
        String userId = request.getHeader("userId");
        if (StringUtils.isEmpty(userId))
            userId = "095f95adc9834328a4edbe4b70a731c8";
        return cartService.getCartList(userId);
    }

    @PostMapping("/cart/listbyid")
    public ResponseResult getCartByIds(HttpServletRequest request, HttpServletResponse response, @RequestBody List<CartItem>list){
        String userId = request.getHeader("userId");
        if (StringUtils.isEmpty(userId))
            userId = "095f95adc9834328a4edbe4b70a731c8";
        return cartService.getCartListByids(userId, list);
    }


    @DeleteMapping("/cart/{itemId}")
    public ResponseResult delCart(HttpServletRequest request, HttpServletResponse response,
                                  @PathVariable("itemId") Long itemId){
        String userId = request.getHeader("userId");
        if (StringUtils.isEmpty(userId))
            userId = "095f95adc9834328a4edbe4b70a731c8";
        return cartService.delCart(userId,itemId);
    }

    @DeleteMapping("/cart/list")
    public ResponseResult clearCart(HttpServletRequest request, HttpServletResponse response){
        String userId = request.getHeader("userId");
        if (StringUtils.isEmpty(userId))
            userId = "095f95adc9834328a4edbe4b70a731c8";
        return cartService.clearCart(userId);
    }

    @PostMapping("/item")
    public ResponseResult createOrder(HttpServletRequest request, HttpServletResponse response,
                                      @RequestBody  List<CartItem> list, @RequestParam("addressId") String addressId) {
        if (list.isEmpty()) return ResponseResult.build(400, "CartList can not be empty");
        String userId = request.getHeader("userId");
        if (StringUtils.isEmpty(userId)) userId = "095f95adc9834328a4edbe4b70a731c8";
        CapOrderShipping capOrderShipping = new CapOrderShipping();
        capOrderShipping.setId(addressId);
        try {
            return orderService.createOrder(userId, list, capOrderShipping);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseResult.build(400, e.getMessage());
        }
    }

    @GetMapping("/list")
    public ResponseResult showOrder(HttpServletRequest request, HttpServletResponse response){
        String userId = request.getHeader("userId");
        if (StringUtils.isEmpty(userId)) userId = "095f95adc9834328a4edbe4b70a731c8";
        return orderService.showOrder(userId);
    }

    @PostMapping("/address")
    public ResponseResult addAddress(HttpServletRequest request, @RequestBody CapOrderShipping shipping){
        String userId = request.getHeader("userId");
        if (StringUtils.isEmpty(userId)) userId = "095f95adc9834328a4edbe4b70a731c8";
        return orderService.createAddress(userId, shipping);
    }

    @GetMapping("/address")
    public ResponseResult getAddressList(HttpServletRequest request){
        String userId = request.getHeader("userId");
        if (StringUtils.isEmpty(userId)) userId = "095f95adc9834328a4edbe4b70a731c8";
        return  orderService.showAddressList(userId);
    }

    @PutMapping("/address")
    public ResponseResult updateAddress(@RequestBody CapOrderShipping shipping, HttpServletRequest request){
        String userId = request.getHeader("userId");
        if (StringUtils.isEmpty(userId)) userId = "095f95adc9834328a4edbe4b70a731c8";
        if (StringUtils.isEmpty(shipping.getId()))
            return ResponseResult.build(400, "addressId can not be null!");
        shipping.setUserId(userId);
        return orderService.updateAddress(shipping);
    }
}
