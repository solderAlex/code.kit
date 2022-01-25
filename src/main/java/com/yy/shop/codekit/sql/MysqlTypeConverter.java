package com.yy.shop.codekit.sql;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;

import java.lang.reflect.ParameterizedType;

/**
 * 类型转换，将java的类型转换为sql的类型
 *
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2019/5/5
 * @since 1.0
 */
public class MysqlTypeConverter {

    private final static TypeHandlerRegistry registry = new TypeHandlerRegistry();
    /**
     * 利用mybatis带的typeHandler进行转换
     *
     * @param type
     * @return
     */
    public static String mysqlToJavaType(String type) {
        type = StringUtils.upperCase(type);

        TypeHandler typeHandler = registry.getTypeHandler(JdbcType.forCode(MysqlDefs.mysqlToJavaType(type)));

        // 获取当前new的对象的泛型的父类类型
        ParameterizedType pt = (ParameterizedType) typeHandler.getClass().getGenericSuperclass();

        // 获取泛型的真实类型
        return pt.getActualTypeArguments()[0].getTypeName();
    }
}
