package cn.kilog.cap.es.repository;


import cn.kilog.cap.es.model.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
public interface ElasticRepository extends ElasticsearchRepository<Item, Long> {

    //默认的注释
    //@Query("{\"bool\" : {\"must\" : {\"field\" : {\"content\" : \"?\"}}}}")
    Page<Item> findByTitle(String title, Pageable pageable);

    @Query("{\"bool\" : {\"must\" : {\"field\" : {\"sellPoint.keyword\" : \"?\"}}}}")
    Page<Item> findBySellPoint(String sell_point, Pageable pageable);

    @Query("{\"bool\" : {\"must\" : {\"field\" : {\"itemDesc.keyword\" : \"?\"}}}}")
    Page<Item> findByItemDesc(String item_des, Pageable pageable);


}
