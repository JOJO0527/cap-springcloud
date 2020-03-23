package cn.kilog.cap.manager.service;


import cn.kilog.cap.common.pojo.EUTreeNode;
import cn.kilog.cap.common.pojo.ResponseResult;

import java.util.List;

public interface ContentCategoryService {

    List<EUTreeNode> getCategoryList(long parentId);

    ResponseResult insertContentCategory(long parentId, String name);
}
