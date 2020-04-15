package cn.kilog.cap.portal.service.impl;

import cn.kilog.cap.common.pojo.ResponseResult;
import cn.kilog.cap.manager.pojo.CapItem;
import cn.kilog.cap.manager.pojo.CapItemDesc;
import cn.kilog.cap.portal.pojo.ItemInfo;
import cn.kilog.cap.portal.service.remote.ItemServiceRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.kilog.cap.portal.service.ItemService;

import java.util.List;

/**
 * 商品信息管理Service
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemServiceRemote itemServiceRemote;

	@Override
	public ItemInfo getItemById(Long itemId) {

//        try {
//            //调用rest的服务查询商品基本信息
//            String json = HttpClientUtil.doGet(REST_BASE_URL + ITME_INFO_URL + itemId);
//            if (!StringUtils.isBlank(json)) {
//                ResponseResult ResponseResult = ResponseResult.formatToPojo(json, ItemInfo.class);
//                if (ResponseResult.getStatus() == 200) {
//                    ItemInfo item = (ItemInfo) ResponseResult.getData();
//                    return item;
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        String item = itemServiceRemote.getItemById(itemId);
        if (!item.equals("")){
            ResponseResult responseResult = ResponseResult.formatToPojo(item, ItemInfo.class);
            if (responseResult != null && responseResult.getStatus() == 200)
                return (ItemInfo)responseResult.getData();
        }
        return null;
    }



	/**
	 * 	取商品描述
	 * <p>Title: getItemDescById</p>
	 * <p>Description: </p>
	 * @param itemId
	 * @return
	 * @see ItemService#getItemDescById(Long)
	 */
	@Override
	public CapItemDesc  getItemDescById(Long itemId) {
//		try {
//			//查询商品描述
//			String json = HttpClientUtil.doGet(REST_BASE_URL + ITEM_DESC_URL + itemId);
//			//转换成java对象
//			ResponseResult ResponseResult = ResponseResult.formatToPojo(json, CapItemDesc.class);
//			if (ResponseResult.getStatus() == 200) {
//				CapItemDesc itemDesc = (CapItemDesc) ResponseResult.getData();
//				//取商品描述信息
//				String result = itemDesc.getItemDesc();
////				return itemDesc;
//                return  result;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;

        String item = itemServiceRemote.getItemDescById(itemId);
        if (!item.equals("")){
            ResponseResult responseResult = ResponseResult.formatToPojo(item, CapItemDesc.class);
            if (responseResult != null && responseResult.getStatus() == 200)
                return (CapItemDesc)responseResult.getData();
        }
        return null;
    }





	/**
	 * 根据商品id查询规格参数
	 * <p>Title: getItemParam</p>
	 * <p>Description: </p>
	 * @param itemId
	 * @return
	 * @see ItemService#getItemParam(Long)
	 */
//	@Override
//	public CapItemParamItem getItemParam(Long itemId) {
//		try {
//			String json = HttpClientUtil.doGet(REST_BASE_URL + ITEM_PARAM_URL + itemId);
//			//把json转换成java对象
//			ResponseResult ResponseResult = ResponseResult.formatToPojo(json, CapItemParamItem.class);
//			if (ResponseResult.getStatus() == 200) {
//				CapItemParamItem itemParamItem = (CapItemParamItem) ResponseResult.getData();
////				String paramData = itemParamItem.getParamData();
////				//生成html
////				// 把规格参数json数据转换成java对象
////				List<Map> jsonList = JsonUtils.jsonToList(paramData, Map.class);
////				StringBuffer sb = new StringBuffer();
////				sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"0\" class=\"Ptable\">\n");
////				sb.append("    <tbody>\n");
////				for(Map m1:jsonList) {
////					sb.append("        <tr>\n");
////					sb.append("            <th class=\"tdTitle\" colspan=\"2\">"+m1.get("group")+"</th>\n");
////					sb.append("        </tr>\n");
////					List<Map> list2 = (List<Map>) m1.get("params");
////					for(Map m2:list2) {
////						sb.append("        <tr>\n");
////						sb.append("            <td class=\"tdTitle\">"+m2.get("k")+"</td>\n");
////						sb.append("            <td>"+m2.get("v")+"</td>\n");
////						sb.append("        </tr>\n");
////					}
////				}
////				sb.append("    </tbody>\n");
////				sb.append("</table>");
////				//返回html片段
////				return sb.toString();
//                return itemParamItem;
//			}
//
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return null;
//	}



    @Override
    public List<CapItem> getItemList() {
//        try {
//            //查询过期商品列表
//            String json = HttpClientUtil.doGet(REST_BASE_URL + ITEM_LIST_URL);
////            List<CapItem> itemList = itemServiceRemote.getItemList();
//            //转换成java对象
//            ResponseResult ResponseResult = ResponseResult.formatToList(json, CapItem.class);
//            if (ResponseResult.getStatus() == 200) {
//                List<CapItem> itemList = (List<CapItem>) ResponseResult.getData();
//                //取商品列表
//                return itemList;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
        String  json = itemServiceRemote.getItemList();
         ResponseResult itemList = ResponseResult.formatToList(json, CapItem.class);
        if (itemList != null &&itemList.getStatus() == 200) {
            List<CapItem> data = (List<CapItem>) itemList.getData();
            return data;
        }
        return null;
    }
}
