package cn.kilog.cap.es.service;


import cn.kilog.cap.es.model.Item;
import org.springframework.data.domain.Page;

import java.util.Iterator;
import java.util.List;

public interface ElasticService {

    void createIndex();

    void deleteIndex(String index);

    void save(Item item);

    void saveAll(List<Item> list);

    Iterator<Item> findAll();

    Page<Item> findByTitle(String content);

    Page<Item> findBySellPoint(String firstCode);

    Page<Item> findByItemDesc(String secordCode);

    Page<Item> query(String key);
}

