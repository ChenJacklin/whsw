package cn.itcast.controller.c_servletApi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class ServletController {
    /*
      请求地址：
       http://localhost:8080/spring04_mvc01_war_exploded/servletApi.do?id=100
      应用场景：
        什么时候需要把servlet api 作为控制器方法参数？
          1.获取访问者的ip
          2.文件下载*/
    @RequestMapping("/servletApi")
    public void servletApi(HttpServletRequest request,
                           HttpServletResponse response, HttpSession session,Integer id) throws IOException {
                               System.out.println("request获取请求参数："+ request.getParameter("id"));
                               System.out.println("springmvc封装请求参数值：" + id);
                               System.out.println("访问者的IP： " + request.getRemoteAddr());
                              // Response重定向跳转！！！(地址发生变化)
                               response.sendRedirect(request.getContextPath()+"/pages/success.jsp");
                           }
}
