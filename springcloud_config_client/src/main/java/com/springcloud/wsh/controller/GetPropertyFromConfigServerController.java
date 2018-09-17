package com.springcloud.wsh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试客户端从配置服务中心获取配置文件中的内容
 *
 * @author weishihuai
 * @date 2018/9/17 22:05
 */
@RestController
public class GetPropertyFromConfigServerController {

    private static Logger logger = LoggerFactory.getLogger(GetPropertyFromConfigServerController.class);

    @Value("${com.springcloud.wsh.message}")
    String message;

    @RequestMapping("/getPropertyFromConfigServer")
    public String getPropertyFromConfigServer() {
        String msg = "hello, i am " + message + ", i'm come from config server";
        logger.info(msg);
        return msg;
    }

}
