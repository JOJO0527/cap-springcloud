package cn.kilog.cap.auth.service.impl;

import cn.kilog.cap.auth.model.BaseModuleResources;
import cn.kilog.cap.auth.repository.BaseRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fp295 on 2018/4/9.
 */
@Service
public class BaseModuleResourceService{
    @Autowired
    private BaseRepositoryImpl baseRepository;

    /**
     * 根据用户查询菜单
     * @param userId
     * @return
     */
    public List<BaseModuleResources> getMenusByUserId(String userId) {
//        return ((BaseModuleResourcesMapper)mapper).getMenusByUserId(userId);
        return  baseRepository.findByField(BaseModuleResources.class,"id",userId);
    }
//
//    public List<BaseModuleResources> getModuleTree(String id, String systemId) {
//        return ((BaseModuleResourcesMapper)mapper).selectModuleTree(id, systemId);
//    }
}
