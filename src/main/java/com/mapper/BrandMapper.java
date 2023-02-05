package com.mapper;

import com.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {
    /**
     * 查询所有
     *
     * @return
     */
    List<Brand> selectAll();

    /**
     * 根据id查找
     *
     * @param id
     * @return
     */
    Brand selectById(int id);

    /**
     * 多条件动态查询
     *
     * @param status
     * @param companyName
     * @param brandName
     * @return
     */
    List<Brand> selectByCondition(@Param("status") int status,
                                  @Param("companyName") String companyName,
                                  @Param("brandName") String brandName);

    /**
     * 添加
     *
     * @param brand
     */
    void add(Brand brand);

    /**
     * 修改
     *
     * @param brand
     */
    void updateById(Brand brand);

    /**
     * 删除
     *
     * @param id
     */
    void deleteById(int id);

    /**
     * 批量删除
     *
     * @param ids
     */
    void deleteByIds(@Param("ids") int[] ids);

    /**
     * 分页查询
     * @param begin
     * @param size
     * @return
     */
    List<Brand> selectByPage(@Param("begin") int begin, @Param("size") int size);

    /**
     * 查询总记录数
     * @return
     */
    int selectTotalCount();

    /**
     * 分页条件查询
     * @param begin
     * @param size
     * @param brand
     * @return
     */
    List<Brand> selectByPageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("brand") Brand brand);

    /**
     * 查询分页条件查询总数
     * @param brand
     * @return
     */
    int selectTotalCountByCondition(Brand brand);
}
