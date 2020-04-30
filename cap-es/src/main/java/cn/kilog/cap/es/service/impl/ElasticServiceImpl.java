package cn.kilog.cap.es.service.impl;



import cn.kilog.cap.es.model.Item;
import cn.kilog.cap.es.repository.ElasticRepository;
import cn.kilog.cap.es.service.ElasticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service("elasticService")
public class ElasticServiceImpl implements ElasticService {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchTemplate;
    @Autowired
    private ElasticRepository elasticRepository;

    private Pageable pageable = PageRequest.of(0,10);

    @Override
    public void createIndex() {
        elasticsearchTemplate.createIndex(Item.class);
    }

    @Override
    public void deleteIndex(String index) {
        elasticsearchTemplate.deleteIndex(index);
    }

    @Override
    public void save(Item item) {
        elasticRepository.save(item);
    }

    @Override
    public void saveAll(List<Item> list) {
        elasticRepository.saveAll(list);
    }

    @Override
    public Iterator<Item> findAll() {
        return elasticRepository.findAll().iterator();
    }

    @Override
    public Page<Item> findByTitle(String title) {
        return elasticRepository.findByTitle(title,pageable);
    }

    @Override
    public Page<Item> findBySellPoint(String sellPoint){
        return elasticRepository.findBySellPoint(sellPoint,pageable);
    }

    @Override
    public Page<Item> findByItemDesc(String itemDesc) {
        return elasticRepository.findByItemDesc(itemDesc,pageable);
    }

    @Override
    public Page<Item> query(String key) {
        return elasticRepository.findByTitle(key,pageable);
    }
}

