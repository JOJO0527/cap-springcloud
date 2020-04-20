package cn.kilog.cap.order.controller;

import cn.kilog.cap.common.pojo.ResponseResult;
import cn.kilog.cap.order.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.channels.Pipe;

@RestController
@RequestMapping("cart")
@Slf4j
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("{itemId}/{num}")
    public ResponseResult addCart(
            HttpServletRequest request, HttpServletResponse response,
            @PathVariable("itemId") Long itemId, @PathVariable("num") Integer number){
        String userId = request.getHeader("userId");
        if (StringUtils.isEmpty(userId))
            userId = "095f95adc9834328a4edbe4b70a731c8";
        return cartService.addCart(userId,itemId ,number);
    }

    @GetMapping("list")
    public ResponseResult getCart(HttpServletRequest request, HttpServletResponse response){
        String userId = request.getHeader("userId");
        if (StringUtils.isEmpty(userId))
            userId = "095f95adc9834328a4edbe4b70a731c8";
        return cartService.getCartList(userId);
    }

    @DeleteMapping("{itemId}")
    public ResponseResult delCart(HttpServletRequest request, HttpServletResponse response,
                                  @PathVariable("itemId") Long itemId){
        String userId = request.getHeader("userId");
        if (StringUtils.isEmpty(userId))
            userId = "095f95adc9834328a4edbe4b70a731c8";
        return cartService.delCart(userId,itemId);
    }

    @DeleteMapping("list")
    public ResponseResult clearCart(HttpServletRequest request, HttpServletResponse response){
        String userId = request.getHeader("userId");
        if (StringUtils.isEmpty(userId))
            userId = "095f95adc9834328a4edbe4b70a731c8";
        return cartService.clearCart(userId);
    }
}
