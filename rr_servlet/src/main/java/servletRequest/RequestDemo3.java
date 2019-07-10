package servletRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
请求头：
referer:判断一个地址非法链接
 */
public class RequestDemo3 extends HttpServlet {
    //默认
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*resp.setContentType("text/html;charset=utf-8");//解决中文乱码*/
        resp.setHeader("Content-Type","text/html");
        resp.setCharacterEncoding("utf-8");

        //获取请求头：referer
        String referer = req.getHeader("referer");
        System.out.println(referer);
        /*
        非法链接：
        1>直接访问后台的资源 referer:null
        2>如果没有经过广告页面的跳转： referer.contains("adv.html")
         */
        if(referer == null || !referer.contains("adv.html")){
            resp.getWriter().print("您当前访问的是非法链接，<a href='/adv.html'>跳转广告页面下载</a>");
        }else{
            resp.getWriter().print("正在下载资源");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
