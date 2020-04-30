package cn.kilog.cap.es.controller;

import cn.kilog.cap.common.pojo.ResponseResult;
import cn.kilog.cap.es.model.Item;
import cn.kilog.cap.es.service.ElasticService;
import cn.kilog.cap.es.service.ItemService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;

@Log4j2
@RestController
@RequestMapping("/search")
public class SearchController {


    @Autowired
    private ElasticService elasticService;

    @Autowired
    private ItemService itemService;

    private Pageable pageable = PageRequest.of(0,10);

    @GetMapping("/init")
    public void init() {
        elasticService.createIndex();
//        List<DocBean> list = new ArrayList<>();
//        list.add(new DocBean(1L, "XX0193", "XX8064", "xxxxxx", 1));
//        list.add(new DocBean(2L, "XX0210", "XX7475", "xxxxxxxxxx", 1));
//        list.add(new DocBean(3L, "XX0257", "XX8097", "xxxxxxxxxxxxxxxxxx", 1));
//        elasticService.saveAll(list);

    }

    @GetMapping("/all")
    public Iterator<Item> all() {
        return elasticService.findAll();
    }

    @GetMapping("/{title}")
    public ResponseResult findByTitle (@PathVariable String title){
        Page<Item> items = elasticService.findByTitle(title);
        return ResponseResult.ok(items.getContent());
    }

    @GetMapping("/importall")
    public ResponseResult importAll(){
        itemService.importAllItems();
        return ResponseResult.ok();
    }
}

