package servletRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/*
get、post通用的方法
getParameter(String name);
getParameterNames(); Enurmation
 */

/*
1>tomcat服务器拿到请求数据
2>tomcat服务器将请求数据封装到HttpServletRequest对象里
3>调用doGet方法将request对象传递到servlet中
 */
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //4>通过request对象获取信息

        //获取请求行的信息：
        //1.请求方式：public String getMethod()
        String method = req.getMethod();
        System.out.println(method);
        //2.请求uri,URL
        // public String getRequestURI()
        //public StringBuffer getRequestURL()
        System.out.println("URI"+req.getRequestURI());
        System.out.println("URL:"+req.getRequestURL().toString());
        //3.http协议的版本
        //getProtocol()
        System.out.println(req.getProtocol());
        System.out.println("-------------");
        //get方式获取前台页面表单出来的参数：
        /*String  params = req.getQueryString();
        System.out.println(params);*/
        String username = new String(req.getParameter("username")
                .getBytes("iso-8859-1"),"utf-8");//解决中文乱码;
        String pwd = req.getParameter("pwd");
        System.out.println(username);
        System.out.println(pwd);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getMethod());
        //Post方式获取参数数据
        //使用InputStream读出实体内容的参数
        InputStream inputStream = req.getInputStream();
        //一次读取一个字节数组
        byte[] buff = new byte[1024];
        int len = 0;
        while((len=inputStream.read(buff)) !=-1){
            String content = new String(buff,0,len);
            System.out.println(content);
        }
    }
}
