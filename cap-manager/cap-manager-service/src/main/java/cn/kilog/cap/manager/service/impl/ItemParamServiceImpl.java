package cn.kilog.cap.manager.service.impl;


import cn.kilog.cap.manager.service.ItemParamService;
import cn.kilog.cap.manager.mapper.CapItemParamMapper;
import cn.kilog.cap.manager.pojo.CapItemParam;
import cn.kilog.cap.manager.pojo.CapItemParamExample;
import cn.kilog.cap.common.pojo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 商品规格参数模板管理
 * <p>Title: ItemParamServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p>
 */
@Service
public class ItemParamServiceImpl implements ItemParamService {

	@Autowired
	private CapItemParamMapper itemParamMapper;

	@Override
	public ResponseResult getItemParamByCid(long cid) {
		CapItemParamExample example = new CapItemParamExample();
		CapItemParamExample.Criteria criteria = example.createCriteria();
		criteria.andItemCatIdEqualTo(cid);
		List<CapItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);
		//判断是否查询到结果
		if (list != null && list.size() > 0) {
			return ResponseResult.ok(list.get(0));
		}

		return ResponseResult.ok();
	}

	@Override
	public ResponseResult insertItemParam(CapItemParam itemParam) {
		//补全pojo
		itemParam.setCreated(new Date());
		itemParam.setUpdated(new Date());
		//插入到规格参数模板表
		itemParamMapper.insert(itemParam);
		return ResponseResult.ok();
	}

}
