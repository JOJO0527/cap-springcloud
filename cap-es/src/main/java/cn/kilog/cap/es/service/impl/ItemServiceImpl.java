package cn.kilog.cap.es.service.impl;

import cn.kilog.cap.common.pojo.ResponseResult;
import cn.kilog.cap.es.mapper.ItemMapper;
import cn.kilog.cap.es.model.Item;
import cn.kilog.cap.es.repository.ElasticRepository;
import cn.kilog.cap.es.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private ElasticRepository elasticRepository;

    @Override
    public ResponseResult importAllItems() {
        //查询商品列表
        List<Item> list = itemMapper.getItemList();
        elasticRepository.saveAll(list);
        return ResponseResult.ok();
    }
}
