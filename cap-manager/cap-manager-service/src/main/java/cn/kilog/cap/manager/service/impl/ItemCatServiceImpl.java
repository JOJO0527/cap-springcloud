package cn.kilog.cap.manager.service.impl;


import cn.kilog.cap.manager.service.ItemCatService;
import cn.kilog.cap.manager.mapper.CapItemCatMapper;
import cn.kilog.cap.manager.pojo.CapItemCat;
import cn.kilog.cap.manager.pojo.CapItemCatExample;
import cn.kilog.cap.common.pojo.EUTreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品分类管理
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private CapItemCatMapper itemCatMapper;
	@Override
	public List<EUTreeNode> getCatList(long parentId) {

		//创建查询条件
		CapItemCatExample example = new CapItemCatExample();
		CapItemCatExample.Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//根据条件查询
		List<CapItemCat> list = itemCatMapper.selectByExample(example);
		List<EUTreeNode> resultList = new ArrayList<>();
		//把列表转换成treeNodelist
		for (CapItemCat capItemCat : list) {
			EUTreeNode node = new EUTreeNode();
			node.setId(capItemCat.getId());
			node.setText(capItemCat.getName());
			node.setState(capItemCat.getIsParent()?"closed":"open");
			resultList.add(node);
		}
		//返回结果
		return resultList;
	}

}
