package com.springcloud.wsh.sourceloader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @Title: CustomPropertySourceLoader
 * @ProjectName springcloud_confing_center
 * @Description: 自定义PropertySourceLoader解决中文乱码问题
 * @Author WeiShiHuai
 * @Date 2018/9/18 13:43
 */
public class CustomPropertySourceLoader implements PropertySourceLoader {

    private static Logger logger = LoggerFactory.getLogger(CustomPropertySourceLoader.class);
    private static final String CHARACTER_ENCODING = "utf-8";

    /**
     * 指定文件扩展名称(.properties、.xml)
     *
     * @return
     */
    @Override
    public String[] getFileExtensions() {
        return new String[]{"properties", "xml"};
    }

    @Override
    public PropertySource<?> load(String name, Resource resource, String profile) throws IOException {
        if (null == profile) {
            Properties properties = getProperties(resource);
            if (!properties.isEmpty()) {
                return new PropertiesPropertySource(name, properties);
            }
        }
        return null;
    }

    private Properties getProperties(Resource resource) {
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = resource.getInputStream();
            //指定load方法的编码为utf-8,默认是ISO8859-1
            properties.load(new InputStreamReader(inputStream, CHARACTER_ENCODING));
            inputStream.close();
        } catch (IOException e) {
            logger.error("加载配置文件失败", e);
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    logger.error("关闭流失败", e);
                }
            }
        }
        return properties;
    }

}
