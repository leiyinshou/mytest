package cn.kgc.demo.dao;


import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseMapper<T> {
    int deleteByPrimaryKey(Integer id);

    int insert(T t);

    int insertSelective(T t);

    T selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);

    //查询所有数据
    List<T> selAll();

    //根据条件分页查询数据
    List<T> selPageByParams(T t);

    //批量删除数据
    int deleteBatchByIds(@Param("ids") Integer[] ids);

    //条件查询单个数据
    T selTByParams(T t);

    List<T> selListTByParams(T t);

    int updBatchTByIds(@Param("t") T t, @Param("ids") Integer[] ids);

    Long selCountByParams(T t);
}
