package cn.kilog.cap.manager.service.impl;

import cn.kilog.cap.manager.service.ContentCategoryService;
import cn.kilog.cap.manager.mapper.CapContentCategoryMapper;
import cn.kilog.cap.manager.pojo.CapContentCategory;
import cn.kilog.cap.manager.pojo.CapContentCategoryExample;
import cn.kilog.cap.common.pojo.EUTreeNode;
import cn.kilog.cap.common.pojo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 内容分类管理
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	@Autowired
	private CapContentCategoryMapper contentCategoryMapper;
	@Override
	public List<EUTreeNode> getCategoryList(long parentId) {
		//根据parentid查询节点列表
		CapContentCategoryExample example = new CapContentCategoryExample();
		CapContentCategoryExample.Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//执行查询
		List<CapContentCategory> list = contentCategoryMapper.selectByExample(example);
		List<EUTreeNode> resultList = new ArrayList<>();
		for (CapContentCategory capContentCategory : list) {
			//创建一个节点
			EUTreeNode node = new EUTreeNode();
			node.setId(capContentCategory.getId());
			node.setText(capContentCategory.getName());
			node.setState(capContentCategory.getIsParent()?"closed":"open");

			resultList.add(node);
		}
		return resultList;
	}
	@Override
	public ResponseResult insertContentCategory(long parentId, String name) {

		//创建一个pojo
		CapContentCategory contentCategory = new CapContentCategory();
		contentCategory.setName(name);
		contentCategory.setIsParent(false);
		//'状态。可选值:1(正常),2(删除)',
		contentCategory.setStatus(1);
		contentCategory.setParentId(parentId);
		contentCategory.setSortOrder(1);
		contentCategory.setCreated(new Date());
		contentCategory.setUpdated(new Date());
		//添加记录
		contentCategoryMapper.insert(contentCategory);
		//查看父节点的isParent列是否为true，如果不是true改成true
		CapContentCategory parentCat = contentCategoryMapper.selectByPrimaryKey(parentId);
		//判断是否为true
		if(!parentCat.getIsParent()) {
			parentCat.setIsParent(true);
			//更新父节点
			contentCategoryMapper.updateByPrimaryKey(parentCat);
		}
		//返回结果
		return ResponseResult.ok(contentCategory);
	}

}
