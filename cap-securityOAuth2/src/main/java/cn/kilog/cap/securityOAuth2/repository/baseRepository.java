package cn.kilog.cap.securityOAuth2.repository;

import cn.kilog.cap.securityOAuth2.pojo.Params;
import java.util.LinkedHashMap;
import java.util.List;

public interface baseRepository<T ,ID>{

    /**
     * 保存数据对象
     * @param entity
     * @return
     */
    Boolean save(T entity);
    /**
     * 根据id查询
     * @param clazz
     * @param id
     * @return
     */
    T findByid(Class<T> clazz,ID id);
    /**
     * 根据表名，字段，参数查询，拼接sql语句
     * @param  clazz 表的class
     * @param filed 字段名
     * @param o 字段参数
     * @return
     */
    List<T> findByField(Class<T> clazz, String filed, Object o);

    /**
     * 多个字段的查询
     * @param clazz 表的class
     * @param map 将你的字段传入map中
     * @return
     */
    List<T> findByMoreFiled(Class<T> clazz, LinkedHashMap<String,Object> map);

    /**
     * 根据表的id删除数据
     * @param  entity
     */
    Boolean delete(T entity);
    /**
     * 更新对象
     * @param e
     * @return
     */
    Boolean update(T e ,ID id);
    /**
     * 根据条件查询总条数返回object类型
     * @param clazz 表的class
     * @param map 传入参数放入map中
     * @return
     */
    Integer findCount(Class<T> clazz, LinkedHashMap<String,Object> map);

    /**
     * 通过传入自定义参数查询
     * @param clazz
     * @param params
     * @return
     */
    List<T> findByParams(Class<T> clazz , Params params);

    /**
     * 根据id删除
     * @param clazz
     * @param id
     * @return
     */
    Boolean deleteById(Class<T> clazz, ID id);

    /**
     * 通过id集合批量删除
     * @param clazz
     * @param ids
     * @return
     */
    Boolean deleteByIds(Class<T> clazz , List<ID> ids);
}