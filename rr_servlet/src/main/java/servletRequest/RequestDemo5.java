package servletRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/*
get方式提交和Post方式提交获取参数数据的通用方式
 */
public class RequestDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        getParameter(String name):通过获取参数名称（表单的name属性值)获取参数值
        getParameterNames() 获取所有的参数内容，返回的是Enurmation(类似于Iterator)
        getParameterMap() 获取Map集合<String,String[]>
         */
        String username = new String(req.getParameter("username")
                .getBytes("iso-8859-1"),"utf-8");//解决中文乱码
        String pwd = req.getParameter("pwd");
        System.out.println(username);
        System.out.println(pwd);
        System.out.println("------------");
        //开发中用到
        Enumeration<String> enums = req.getParameterNames();
        while(enums.hasMoreElements()){//判断是否由下一个可以迭代的元素
            String paramName = enums.nextElement();
            //默认第一个
            String paramValue = new String(req.getParameter(paramName)
                    .getBytes("iso-8859-1"),"utf-8");//解决中文乱码
            System.out.println(paramName+"="+paramValue);
        }
        System.out.println("------------");
        Map<String,String[]> parameterMap = req.getParameterMap();
        Set<Map.Entry<String,String[]>> entrySet = parameterMap.entrySet();
        for(Map.Entry<String,String[]> entry : entrySet){
           String paramName = entry.getKey();
           //表单中：复选框：可以勾选多个内容（name属性名称是一样的)
           String[] paramValue = entry.getValue();
           for(int i=0;i<paramValue.length; i++){
               paramValue[i] = new String(paramValue[i]
                       .getBytes("iso-8859-1"),"utf-8");
           }
            System.out.println(paramName+"="+ Arrays.toString(paramValue));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*Enumeration<String> enums = req.getParameterNames();
        while(enums.hasMoreElements()){//判断是否由下一个可以迭代的元素
            String paramName = enums.nextElement();
            String paramValue = new String(req.getParameter(paramName)
                    .getBytes("iso-8859-1"),"utf-8");//解决中文乱码
            System.out.println(paramName+"="+paramValue);
        }*/
        doGet(req,resp);
    }
}
