package com.yy.shop.codekit.configurer;

import com.intellij.openapi.vfs.VirtualFile;
import com.yy.shop.codekit.common.constants.ConfigConst;
import com.yy.shop.codekit.common.exception.CodeKitException;
import com.yy.shop.codekit.configurer.properties.CodeKitProperties;
import com.yy.shop.codekit.configurer.properties.JdbcProperties;
import com.yy.shop.codekit.configurer.properties.TableProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 描述: codekit.properties配置文件
 *
 * @author 钟超 mailto:zhongchao1@yy.com
 * @version 创建时间：2020/11/3 2:09 下午
 */
public class CodeKitProfileLoader {
    /**
     * 读取配置文件，加载配置
     *
     * @param configFile
     */
    public void load(VirtualFile configFile) {

        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(configFile.getPath()));
        } catch (FileNotFoundException ex) {
            throw new CodeKitException("codekit.properties不存在");
        } catch (IOException e) {
            throw new CodeKitException("codekit.properties读取错误");
        }
        CodeKitProperties.instance().setEntityName(properties.getProperty(ConfigConst.KEY_PREFIX_DO + ConfigConst.KEY_SUFFIX_NAME, ""));
        CodeKitProperties.instance().setPkg(properties.getProperty(ConfigConst.KEY_PREFIX_PROJECT + ConfigConst.KEY_SUFFIX_PACKAGE, ""));
        CodeKitProperties.instance().setDalPkg(properties.getProperty(ConfigConst.KEY_PREFIX_PROJECT + "dal." + ConfigConst.KEY_SUFFIX_PACKAGE, ""));

        TableProperties tableProperties = readTableProperties(properties);
        JdbcProperties jdbcProperties = readJdbcProperties(properties);

        CodeKitProperties.instance().setTable(tableProperties);
        CodeKitProperties.instance().setJdbc(jdbcProperties);
    }

    private static TableProperties readTableProperties(Properties properties) {
        TableProperties tableProperties = new TableProperties();
        tableProperties.setName(properties.getProperty(ConfigConst.KEY_PREFIX_TABLE + ConfigConst.KEY_SUFFIX_NAME));
        tableProperties.setComment(properties.getProperty(ConfigConst.KEY_PREFIX_TABLE + ConfigConst.KEY_SUFFIX_COMMENT));
        return tableProperties;
    }

    private static JdbcProperties readJdbcProperties(Properties properties) {
        JdbcProperties jdbcProperties = new JdbcProperties();
        jdbcProperties.setUrl(properties.getProperty(ConfigConst.KEY_PREFIX_JDBC + ConfigConst.KEY_SUFFIX_URL));
        jdbcProperties.setUser(properties.getProperty(ConfigConst.KEY_PREFIX_JDBC + ConfigConst.KEY_SUFFIX_USER));
        jdbcProperties.setPassword(properties.getProperty(ConfigConst.KEY_PREFIX_JDBC + ConfigConst.KEY_SUFFIX_PASSWORD));
        return jdbcProperties;
    }
}
