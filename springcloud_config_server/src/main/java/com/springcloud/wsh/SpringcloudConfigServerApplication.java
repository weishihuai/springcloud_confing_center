package com.springcloud.wsh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 配置中心
 * 证明配置服务中心是否可以从远程程序获取配置信息:
 * 地址: localhost:1111/aaaa/dev实际是没有对应的文件。如果真有文件，返回的json在会有propertySources属性，它的值就是文件的内容。例如http://localhost:8888/config-client/dev 对应git仓库中的config-client-dev.propeties文件
 *
 * @author weishihuai
 * @date 2018/09/17 22:18
 */
@SpringBootApplication
//@EnableConfigServer注解用于开启Spring Cloud Config配置功能
@EnableConfigServer
public class SpringcloudConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConfigServerApplication.class, args);
    }
}
