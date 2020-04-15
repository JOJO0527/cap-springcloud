package cn.kilog.cap.portal.service.remote;

import cn.kilog.cap.portal.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "cap-rest",configuration = FeignConfig.class)
public interface ItemServiceRemote {
    @RequestMapping("/item/desc/{itemId}")
    String getItemDescById(@PathVariable("itemId") Long itemId);

    @RequestMapping("/item/param/{itemId}")
    String getItemParam(@PathVariable("itemId") Long itemId);
    //    CapItemParamItem getItemParam(Long itemId);

    @RequestMapping("/item/info/{itemId}")
    String getItemById(@PathVariable("itemId") Long itemId);
//    ItemInfo getItemById(Long itemId);

    @RequestMapping("/item/list")
//    List<CapItem> getItemList();
    String getItemList();

}
