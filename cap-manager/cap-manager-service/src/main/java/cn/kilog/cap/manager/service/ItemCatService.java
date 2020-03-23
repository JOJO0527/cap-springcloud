package cn.kilog.cap.manager.service;


import cn.kilog.cap.common.pojo.EUTreeNode;

import java.util.List;

public interface ItemCatService {

    List<EUTreeNode> getCatList(long parentId);
}
