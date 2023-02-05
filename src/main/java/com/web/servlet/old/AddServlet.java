package com.web.servlet.old;

import com.alibaba.fastjson.JSON;
import com.pojo.Brand;
import com.service.BrandService;
import com.service.impl.BrandServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    private BrandService service = new BrandServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收数据
        String params = request.getReader().readLine();
        //转为Brand对象
        Brand brand = JSON.parseObject(params, Brand.class);
        service.add(brand);
        response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
