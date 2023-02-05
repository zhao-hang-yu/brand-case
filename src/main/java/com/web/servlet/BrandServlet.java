package com.web.servlet;

import com.alibaba.fastjson.JSON;
import com.pojo.Brand;
import com.pojo.PageBean;
import com.service.BrandService;
import com.service.impl.BrandServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet {
    private BrandService service = new BrandServiceImpl();

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //调用service
        List<Brand> brands = service.selectAll();
        //转为JSON
        String jsonString = JSON.toJSONString(brands);
        //写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收数据
        String params = request.getReader().readLine();
        //转为Brand对象
        Brand brand = JSON.parseObject(params, Brand.class);
        service.add(brand);
        //成功标记
        response.getWriter().write("success");
    }

    public void updateById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收数据
        String params = request.getReader().readLine();
        //转为Brand对象
        Brand brand = JSON.parseObject(params, Brand.class);
        service.updateById(brand);
        //成功标记
        response.getWriter().write("success");
    }

    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收数据
        String params = request.getReader().readLine();
        //转为int
        int id = Integer.parseInt(params);
        service.deleteById(id);
        //成功标记
        response.getWriter().write("success");
    }

    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收数据
        String params = request.getReader().readLine();
        //转为int[]
        int[] ids = JSON.parseObject(params, int[].class);
        for(int x : ids) {
            System.out.println(x);
        }
        service.deleteByIds(ids);
        //成功标记
        response.getWriter().write("success");
    }

    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收 当前页码 和 每页展示条数    url?currentPage=1&pageSize=5
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        //转为int
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        //查询
        PageBean<Brand> pageBean = service.selectByPage(currentPage, pageSize);
        String jsonString = JSON.toJSONString(pageBean);
        //写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收 当前页码 和 每页展示条数    url?currentPage=1&pageSize=5
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        //转为int
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        //接收Brand数据
        String params = request.getReader().readLine();



        System.out.println(params);




        //转为Brand
        Brand brand = JSON.parseObject(params, Brand.class);
        System.out.println(brand.toString());
        //查询
        PageBean<Brand> pageBean = service.selectByPageAndCondition(currentPage, pageSize, brand);
        String jsonString = JSON.toJSONString(pageBean);
        //写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
}