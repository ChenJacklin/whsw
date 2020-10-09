package cn.itcast.controller.b_requestParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Date;


@Controller
public class UserController {
    //1.pringmvc封装请求数据：简单类型作为方法参数
    @RequestMapping("/save1")
    public String save1(Integer id , String name){
        System.out.println("id="+id);
        System.out.println("name="+name);
        return "success";
    }

    //2.pringmvc封装请求数据：对象作为方法参数
    @RequestMapping("/save2.do")
    public String save2(User1 user){
        System.out.println("user1="+user);
        return "success";
    }

    //3.SpringMVC封装请求数据: 封装数据到对象，对象关联的对象(User对象里封装了Address对象)
    @RequestMapping("save3")
    public String save3(User2 user){
        System.out.println("user="+user);
        return "success";
    }


    //4.SpringMVC封装请求数：封装数据到对象，对象关联的对象(User对象里封装了Address对象)，对象关联的集合(User对象里封装了User类型的集合)
    @RequestMapping("/save4")
    public String save4(User3 user){
        System.out.println("user="+user);
        return "success";
    }


    /*
      @RequestParam 注解
      1. 定义在方法参数上
      2. 建立请求参数与方法参数的对应关系
      3. 当-->请求参数<--与--->方法形参名称<---不一致的时候使用
      4. 属性
         value  指定对应的请求参数名称
         required
            true:
               表示-->必须<--传入该参数
             http://localhost:8080/spring04_mvc01_war_exploded/user/query.do  不传递参数，报错，400+Bad Request

            false: 参数不传递也可以，不会报错
         defaultValue 给参数默认值。如果没有传递参数就使用默认值。*/
    //请求路径：
    //http://localhost:8080/spring04_mvc01_war_exploded/user/query.do?username=Jacky
    @RequestMapping("/query")
    public String query(@RequestParam(name ="username") String name){//此处的方法形参名name与请求的url传递的参数名username不一样时就需要使用@RequestParam注解！！！
        System.out.println("name="+name);
        return "success";
    }

    @RequestMapping("/query2")
    public String query2( String name){//此处的方法形参名name与请求的url传递的参数名name是一样的
        System.out.println("name="+name);
        return "success";
    }




    /*
      自定义类型转换器
      思考：请求的日期字符串，能否自动转换为java.util.Date类型。
      请求：
          http://localhost:8080/spring04_mvc01_war_exploded/user/search.do?birth=1998-04-24
      日志：
           Failed to convert value of type
           'java.lang.String' to required type 'java.util.Date';
      页面：
          400 + Bad Request 请求参数问题
      解决？
       1、写一个类，实现Converter接口
       2、springmvc.xml配置转换器 */

    @RequestMapping("/search")
    public String search(Date birth){//注意Date不要写成Data!!!!导致服务器报500！！！！
        System.out.println("birth="+birth);
        return "success";
    }





}
