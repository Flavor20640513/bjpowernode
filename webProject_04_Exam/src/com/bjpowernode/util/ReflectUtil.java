package com.bjpowernode.util;

import com.bjpowernode.entity.Question;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReflectUtil {
     public  static List selectList(ResultSet rs, Class entityClass) throws Exception{
         Field[] fields = entityClass.getDeclaredFields();   //得到每一个字段的集合
         List list=new ArrayList();
         while (rs.next()){
             Object entity=entityClass.newInstance();
             for (Field field : fields) {      //遍历每一个字段
                 String fieldName=field.getName();
                 String typeName=field.getType().getSimpleName();
                 String value=null;
                 try {
                     value=rs.getString(fieldName);
                 } catch (SQLException e) {
                     continue;
                 }
                 if (value!=null){
                     field.setAccessible(true);
                     if ("Integer".equals(typeName)){
                         field.set(entity, Integer.valueOf(value));
                     }else if ("String".equals(typeName)){
                         field.set(entity, value);
                     }else if ("Double".equals(typeName)){
                         field.set(entity, Double.valueOf(value));
                     }
                 }
             }
             list.add(entity);
         }
        return list;
     }
     public static List selectList2(ResultSet rs,Class entityClass) throws  Exception {
         List list=new ArrayList();
         return list;
     }
}
