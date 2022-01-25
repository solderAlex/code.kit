package com.yy.shop.codekit.configurer;

import com.intellij.openapi.vfs.VirtualFile;
import com.yy.shop.codekit.configurer.properties.CodeKitProperties;
import com.yy.shop.codekit.configurer.properties.FieldMappingProperties;
import com.yy.shop.codekit.configurer.properties.JdbcProperties;
import com.yy.shop.codekit.configurer.properties.TableProperties;
import com.yy.shop.codekit.sql.DBClient;

import java.util.List;

/**
 * code from db 配置读取
 *
 * @author <a href="mailto:zhongchao@gegejia.com">珞玉</a>
 * @version 1.0 2019/4/26
 * @since 1.0
 */
public class DbCodeKitProfileLoader extends CodeKitProfileLoader {

    @Override
    public void load(VirtualFile configFile) {
        super.load(configFile);

        JdbcProperties jdbcProperties = CodeKitProperties.instance().getJdbc();
        TableProperties tableProperties = CodeKitProperties.instance().getTable();

        // 读取数据库, 设置field
        List<FieldMappingProperties> fields = DBClient.listColumns(tableProperties.getName(), jdbcProperties.getUrl(), jdbcProperties.getUser(), jdbcProperties.getPassword());
        tableProperties.setFields(fields);
    }
}
