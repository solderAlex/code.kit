package com.yy.shop.codekit.sql;

import com.yy.shop.codekit.common.exception.CodeKitException;
import com.yy.shop.codekit.configurer.properties.FieldMappingProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * db client
 *
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2019/4/26
 * @since 1.0
 */
public class DBClient {

    public static List<FieldMappingProperties> listColumns(String tableName, String url, String user, String password) {
        Connection conn = create(url, user, password);

        String sql = "select column_name, data_type, column_comment from information_schema.columns where table_name = ? and table_schema = ?";

        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, tableName);

            String schema = url.substring(url.lastIndexOf("/") + 1);
            statement.setString(2, schema);

            rs = statement.executeQuery();

            List<FieldMappingProperties> fields = new ArrayList<>();
            while (rs.next()) {
                FieldMappingProperties field = new FieldMappingProperties();
                String column = rs.getString("column_name");
                String type = rs.getString("data_type");
                String comment = rs.getString("column_comment");

                field.setColumn(column);
                field.setType(type);
                field.setComment(comment);
                fields.add(field);
            }
            return fields;

        } catch (SQLException e) {
            throw new CodeKitException("获取表：" + tableName + "信息失败");
        } finally {
            assert rs != null;
            try {
                rs.close();
                statement.close();
                conn.close();
            } catch (SQLException ex) {
                System.out.println("数据库释放连接失败");
            }
        }
    }

    private static Connection create(String url, String user, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url + "?useSSL=false", user, password);
        } catch (Exception e) {
            throw new CodeKitException("数据库连接失败");
        }
    }
}
