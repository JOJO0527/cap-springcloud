package cn.kilog.cap.securityOAuth2.repository;

import cn.kilog.cap.securityOAuth2.utils.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import cn.kilog.cap.securityOAuth2.pojo.Params;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.*;

@Repository
public class BaseRepositoryImpl<T,ID> implements baseRepository<T,ID>{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Boolean save(T entity){
        boolean flag = false;
        try {
            entityManager.persist(entity);
            flag = true;
        }catch (Exception e){
            System.out.println("---------------保存出错---------------");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public T findByid(Class<T> clazz,ID id) {
        T t = null;
        try {
            t = entityManager.find(clazz, id);
        } catch (Exception e) {
            System.out.println("---------------查询出错---------------");
            e.printStackTrace();
        }
        return t;
    }

    @Override
    public List<T> findByField(Class<T> clazz, String filed, Object value ) {
        String tablename = clazz.getName();
        List<T> list = new ArrayList<>();
        try {
            String sql="from "+tablename+" u WHERE u."+filed+"=?1";
            Query query=entityManager.createQuery(sql);
            query.setParameter(1,value);
            list= query.getResultList();
            entityManager.close();
        }catch (Exception e){
            System.out.println("---------------查询出错---------------");
            e.printStackTrace();
        }
        return list;
    }

    @Override
    @Transactional
    public Boolean deleteById(Class<T> clazz, ID id) {
        Boolean flag = false;
        try {
            String tableName = clazz.getName();
            String sql = "delete from "+tableName+" u WHERE u.id = ?1";
            Query query=entityManager.createQuery(sql);
            query.setParameter(1,id);
            int i = query.executeUpdate();
            if(i != 0){
                flag = true;
            }
            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    @Transactional
    public Boolean deleteByIds(Class<T> clazz, List<ID> ids) {
        boolean flag = false;
        List<ID> param = new ArrayList<ID>();
        int index = 1;
        try {
            String tableName = clazz.getName();
            StringBuilder sql = new StringBuilder("delete from "+tableName+" u WHERE u.id in (");
            if (ids != null && ids.size() != 0){
                for (ID id : ids) {
                    sql.append("?").append(index).append(",");
                    param.add(id);
                    index ++ ;
                }
            }
            sql.deleteCharAt(sql.length() - 1 );
            sql.append(")");
            Query query=entityManager.createQuery(sql.toString());
            for (int x = 0;x < param.size();x++) {
                query.setParameter(x+1,param.get(x));
            }
            int i = query.executeUpdate();
            if (i != 0){
                flag = true;
            }
            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<T> findByMoreFiled(Class<T> clazz, LinkedHashMap<String,Object> map) {
        String tablename = clazz.getName();
        List<T> listRe = new ArrayList<>();
        try {
            String sql="from "+tablename+" u WHERE ";
            Set<String> set=null;
            set=map.keySet();
            List<String> list=new ArrayList<>(set);
            List<Object> filedlist=new ArrayList<>();
            int x = 1;
            for (String filed:list){
                sql+="u."+filed+"=?"+x+" and ";
                filedlist.add(filed);
                x++;
            }
            sql=sql.substring(0,sql.length()-4);
            Query query=entityManager.createQuery(sql);
            for (int i=0;i<filedlist.size();i++){
                query.setParameter(i+1,map.get(filedlist.get(i)));
            }
            listRe= query.getResultList();
            entityManager.close();
        }catch (Exception e){
            System.out.println("---------------查询出错---------------");
            e.printStackTrace();
        }
        return listRe;
    }

    @Override
    @Transactional
    public Boolean update(T entity,ID id) {
        boolean flag = false;
        try {
            Object o = entityManager.find(entity.getClass(), id);
            BeanUtils.copyPropertiesExcludeNull(entity,o);
            entityManager.merge(o);
            flag = true;
        } catch (Exception e) {
            System.out.println("---------------查询出错---------------");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    @Transactional
    public Boolean delete(T entity) {  //entity通过设置id来删除相应数据
        boolean flag=false;
        try {
            entityManager.remove(entityManager.merge(entity));
            flag=true;
        }catch (Exception e){
            System.out.println("---------------删除出错---------------");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Integer findCount(Class<T> clazz, LinkedHashMap<String, Object> map) {
        String tablename = clazz.getName();
        Query query= null;
        Object count = 0;
        try {
            String sql="select count(u) from "+tablename+" u WHERE ";
            Set<String> set=null;
            set=map.keySet();
            List<String> list=new ArrayList<>(set);
            List<Object> filedlist=new ArrayList<>();
            int x = 1;
            for (String filed:list){
                sql+="u."+filed+"=?"+ x +" and ";
                x++;
                filedlist.add(filed);
            }
            sql=sql.substring(0,sql.length()-4);
            query = entityManager.createQuery(sql);
            for (int i=0;i<filedlist.size();i++){
                query.setParameter(i+1,map.get(filedlist.get(i)));
            }
            count = query.getSingleResult();
        } catch (Exception e) {
            System.out.println("---------------查询出错---------------");
            e.printStackTrace();
        }
        return Integer.parseInt(count.toString());
    }


    @Override
    public List<T> findByParams(Class<T> clazz, Params params) {
        String tablename = clazz.getName();
        List<T> listRe = new ArrayList<>();
        //jpa运行时需要的参数
        List param = new ArrayList();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("from ").append(tablename).append(" u WHERE 1=1 ");
            int index = 0;
            //拼接sql，添加参数集合
            index = concatSqlForObj(index,param, sql, params.getAnd(), params.getAndPara());
            index = concatSqlForObj(index,param, sql, params.getOr(), params.getOrPara());
            index = concatSqlForList(index,param, sql, params.getBetween(), params.getBetweenPara());
            index = concatSqlForObj(index,param, sql, params.getLessThan(), params.getLessThanPara());
            index = concatSqlForObj(index,param, sql, params.getMoreThan(), params.getMoreThanPara());
            index = concatSqlForObj(index,param, sql, params.getLike(), params.getLikePara());
            index = concatSqlForObj(index,param, sql, params.getNotLike(), params.getNotLikePara());
            index = concatSqlForObj(index,param, sql, params.getOrderBy(), params.getOrderByPara());
            index = concatSqlForObj(index,param, sql, params.getNot(), params.getNotPara());

            index = concatSqlForList(index,param, sql, params.getIn(), params.getInPara());
            index = concatSqlForList(index,param, sql, params.getNotIn(), params.getNotInPara());

            Query query=entityManager.createQuery(sql.toString());
            //limit
            if (params.getLimitPara() != null){
                List list = params.getLimitPara().get("limit");
                query.setFirstResult((Integer) list.get(0));
                query.setMaxResults((Integer) list.get(1));
            }
            for (int i=0;i<param.size();i++){
                query.setParameter(i+1,param.get(i));
            }
            listRe= query.getResultList();
            entityManager.close();
        }catch (Exception e){
            System.out.println("---------------查询出错---------------");
            e.printStackTrace();
        }
        return listRe;
    }

    public static int concatSqlForObj(int index,List param ,StringBuilder sql , List<String> symbols , LinkedHashMap<String , Object> params){
        //拼接sql时需要的参数索引
        int index1 = index;
        //取list中的键值对是需要的索引
        int x = 0;
        if (symbols != null && symbols.size() != 0){
            for (String  symbol: symbols) {
                //通过转换list获取键值对
                List<Map.Entry<String, Object>> indexedList = new ArrayList<Map.Entry<String, Object>>(params.entrySet());
                Map.Entry<String, Object> entry = indexedList.get(x);
                String key = entry.getKey();
                Object value = entry.getValue();

                index1 ++ ;
                x++;

                if (symbol.equals("or")){
                    sql.append(" or u.").append(key).append("=?").append(index1);
                }else if(symbol.equals("<")){
                    sql.append(" and u.").append(key).append("<?").append(index1);
                }else if(symbol.equals(">")){
                    sql.append(" and u.").append(key).append(">?").append(index1);
                }else if(symbol.equals("like")){
                    sql.append(" and u.").append(key).append(" like ?").append(index1);
                }else if(symbol.equals("notlike")){
                    sql.append(" and u.").append(key).append(" not like ?").append(index1);
                }else if(symbol.equals("!=")){
                    sql.append(" and u.").append(key).append(" != ?").append(index1);
                }
                else if(symbol.equals("orderby")){
                    //val的值可取asc 和 desc
                    sql.append(" ORDER BY ").append(key).append(" ").append(value.toString());
                    return index1;
                }
                else {
                    sql.append(" and u."+key + symbol+"?" + index1);
                }
                param.add(value);
            }
        }
        return index1;
    }

    public static int concatSqlForList(int index,List param ,StringBuilder sql , List<String> symbols , LinkedHashMap<String , List> params){
        //拼接sql时需要的参数索引
        int index1 = index;
        //取list中的键值对是需要的索引
        int x = 0;
        if (symbols != null && symbols.size() != 0){
            for (String  symbol: symbols) {
                //通过转换list获取键值对
                List<Map.Entry<String, List>> indexedList = new ArrayList<Map.Entry<String, List>>(params.entrySet());
                Map.Entry<String, List> entry = indexedList.get(x);
                String key = entry.getKey();
                List value = entry.getValue();

                index1 ++ ;
                x++;

                if(symbol.equals("between")){
                    sql.append(" and u.").append(key).append(" between ?").append(index1).append(" and ?").append(index1 + 1);
                    index1 ++;
                }else if (symbol.equals("in") || symbol.equals("notin")){
                    sql.append(" and u.").append(key);
                    if (symbol.equals("in")){
                        sql.append(" in (?");
                    }else {
                        sql.append(" not in (?");
                    }
                    sql.append(index1);
                    param.add(value.get(0));
                    for (int i = 1 ; i < value.size() ; i++){
                        index1 ++;
                        sql.append(",?").append(index1);
                        param.add(value.get(i));
                    }
                    sql.append(")");
                    return index1;
                }
                param.add(value.get(0));
                param.add(value.get(1));
            }
        }
        return index1;
    }
}