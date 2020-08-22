package com.imooc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

/**
 * {@link Properties} {@link RestController}
 *
 * @author huohua
 * @since 2018/5/27
 */
//@RestController
@Controller
public class PropertiesRestController {

    @PostMapping(value = "/add/props",//指定请求的实际地址
            consumes = "text/properties;charset=UTF-8" // Content-Type 过滤媒体类型  指定处理请求的提交内容类型
//        ,produces = "" //指定返回的内容类型，仅当request请求头中的(Accept)类型中包含该指定类型才返回；
//        ,params= ""    //指定request中必须包含某些参数值是，才让该方法处理。
//        ,headers= ""   //指定request中必须包含某些指定的header值，才能让该方法处理请求。
    )
    public Properties addProperties(
//            @RequestBody
            Properties properties) {
        return properties;
    }

}
