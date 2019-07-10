package response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
响应对象：
location:响应头
 */
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //重定向原理:
        //location+302(进一步发送请求)
        //设置响应头
        /*resp.setHeader("location","/adv.html");
        //设置一个状态码
        resp.setStatus(302)*/;

        //简写方式
        resp.sendRedirect("/adv.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
