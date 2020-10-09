package cn.itcast.controller.a_hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//创建HelloController对象，并加入IOC容器
@RequestMapping("login")
public class HelloController {
    /*
      1.请求地址
        http://localhost:8080/hello.do
      2.@RequestMapping 建立请求路径，与处理请求方法的映射关系。
      3.对应的后台处理请求的方法：hello()
      4.处理完请求后，跳转
            http://localhost:8080/spring04_mvc01_war_exploded/pages/success.jsp
            跳转路径的前缀：/pages/    【在springMVC.xml配置】
            跳转的页面名称：success    【控制器方法返回页面名称】
            跳转页面的后缀：.jsp       【在springMVC.xml配置】


     讲解@RequestMapping注解的使用
     @RequestMapping
     1、作用： 建立请求地址与控制器处理请求方法的对应关系
     2、范围：
        2.1定义到类上：  区分不同的模块，对路径进行管理！！！
        2.2定义到方法上：指定方法的访问路径！！！
        最终访问路径： http://localhost:8080/项目名称/类上的路径/方法上的路径
     3、一些写法，
        @RequestMapping("/save.do")
        @RequestMapping("save.do")
        @RequestMapping("save")
        推荐写法：
           @RequestMapping("/save")
        注意：
          A.在注解映射路径中.do后缀可以不写，但是---->访问时候一定要带上。
          B.DispatcherServlet只拦截.do后缀的请求
          C.完整访问地址：
            http://localhost:8080/order/save.do
     4、注解属性
        value  指定请求路径
        path   同value
        name   没有其他意义，只是给路径指定一个名称，增加可读性
        method 当前方法执行的请求方式，不指定默认支持所有请求方式
               method = RequestMethod.POST  表示当前方法只支持post请求 (表单)
               method = RequestMethod.GET   表示当前方法只支持get请求
                                            浏览器直接访问都是get请求
        produces 指定当前方法支持的响应类型、编码等。
        params 指定当前请求必须带固定的参数名称还有参数值
                params = "id=100"
                  http://localhost:8080/order/save.do?id=100   OK
                  http://localhost:8080/order/save.do?id=101   NOK */


    @RequestMapping(value = "hello.do")
    public String hello(){
        System.out.println("处理请求的方法......");
        return "success";
        System.out.println("-----------------------------");
        
    }
}
