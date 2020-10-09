package cn.itcast.controller.d_requestHeader;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestHeaderController {

    /*
      @RequestHeader注解
      1. 获取请求头
      2. 根据指定的请求头，获取请求头对应的值                            String getHeader(String key)  根据指定的key获取对应的value*/
    @RequestMapping("/requestHeader")
    public String requestHeader(@RequestHeader("host") String host){//此处的@RequestHeader("host")------>request.getHeader("host")

        System.out.println("host请求头对应的值是：" + host);
        return "success";
    }



    /*
      @CookieValue
      1. 获取指定的key的cookie的值
      2. 比如：获取cookie中的JSESSIONID值,注意要大写*/
    @RequestMapping("/cookieValue")
    public String cookieValue(@CookieValue("JSESSIONID") String jsessionid){ /*cookie对象查询自己的键和值的方法
                                                                                 1.cookie.getName(); 获取cookie的键
                                                                                 2.cookie.getValue(); 获取cookie的值*/
        System.out.println("cookie中jsessionid对应的cookie的value值是：" + jsessionid);
        return "success";
    }
    /*
      @RequestBody
      1. 获取请求体内容
      2. 需要页面表单post提交
      3. required
           true 默认为true，表示必须要有请求体，否则报错
           false 如果没有请求体不会报错。
      4. 一般不单独使用，要配置jackson支持包，就可以---->自动把请求体（from表单提交的post方法提交的数据）的 "json字符串" 转换为---->对象*/
    @RequestMapping("/requestBody")
    public String requestBody(@RequestBody String body){
        System.out.println("body = " + body);
        return "success";
    }

}

