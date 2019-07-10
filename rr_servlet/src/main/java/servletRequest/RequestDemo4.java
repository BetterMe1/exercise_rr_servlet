package servletRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
doXXX方法和Service（）的区别
servlet方法是servlet程序的入口，通过不同的提交方式来执行不同的doXXX()方法
一般情况：开发者完成任务，必须覆盖具体的doXXX方法
service方法是servlet生命周期的第三个阶段（通过不同的方式执行对应业务doXXX）
 */
public class RequestDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("调用了doGet方法。。。");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("调用了doPost方法。。。");
        //通常在doPost方法中调用doGet()
        doGet(req,resp);
    }

    //service():servlet的服务方法
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("调用了service方法。。。");
    }
}
