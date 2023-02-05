package com.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求对象
        String uri = req.getRequestURI(); // brand-case/brand/selectAll
        //获取方法名
        String methodName = uri.substring(uri.lastIndexOf('/') + 1);

        //执行方法
        //获取BrandServlet字节码对象
        //this-谁调用我，我代表谁  此处代表BrandServlet
        Class<? extends BaseServlet> cls = this.getClass();
        try {
            //获取Method对象
            Method method = cls.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //执行方法
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
