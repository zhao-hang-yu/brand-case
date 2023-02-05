package com.service.impl;

import com.mapper.BrandMapper;
import com.pojo.Brand;
import com.pojo.PageBean;
import com.service.BrandService;
import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements BrandService {
    //创建SqlSessionFactory对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Brand> selectAll() {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //调用方法
        List<Brand> brands = mapper.selectAll();
        //释放资源
        sqlSession.close();
        return brands;
    }

    @Override
    public void add(Brand brand) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //调用方法
        mapper.add(brand);
        //提交事物
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Override
    public void updateById(Brand brand) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //调用方法
        mapper.updateById(brand);
        //提交事物
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Override
    public void deleteById(int id) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //调用方法
        mapper.deleteById(id);
        //提交事物
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Override
    public void deleteByIds(int[] ids) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //调用方法
        mapper.deleteByIds(ids);
        //提交事物
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Override
    public PageBean<Brand> selectByPage(int currentPage, int pageSize) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //调用方法
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        List<Brand> rows = mapper.selectByPage(begin, size);
        int totalCount = mapper.selectTotalCount();
        //封装PageBean对象
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        //释放资源
        sqlSession.close();
        return pageBean;
    }

    @Override
    public PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //调用方法
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        //处理模糊查询参数
        String brandName = brand.getBrandName();
        if(brandName != null && brandName.length() > 0) {
            brand.setBrandName("%" + brandName + "%");
        }
        String companyName = brand.getCompanyName();
        if(companyName != null && companyName.length() > 0) {
            brand.setCompanyName("%" + companyName + "%");
        }
        List<Brand> rows = mapper.selectByPageAndCondition(begin, size, brand);




        System.out.println(rows);




        int totalCount = mapper.selectTotalCountByCondition(brand);
        //封装PageBean对象
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        //释放资源
        sqlSession.close();
        return pageBean;
    }

}
