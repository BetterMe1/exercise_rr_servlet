package servletRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
请求头：
user-agent:浏览器的类型
 */
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取user-agent请求头
        String userAgent = req.getHeader("user-agent");
        System.out.println(userAgent);
        //判断使用的浏览器类型
        if(userAgent.contains("Chrome")){
            System.out.println("您当前使用的是谷歌浏览器");
        }else if(userAgent.contains("firefox")){
            System.out.println("您当前使用的是火狐浏览器");
        }else if(userAgent.contains("Trident")){
            System.out.println("您当前使用的是IE浏览器");
        }else{
            System.out.println("您当前使用的其他的浏览器");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
