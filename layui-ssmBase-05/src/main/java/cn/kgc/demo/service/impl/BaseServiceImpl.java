package cn.kgc.demo.service.impl;

import cn.kgc.demo.dao.BaseMapper;
import cn.kgc.demo.service.BaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    private BaseMapper<T> baseMapper;

    @Override
    public Map<String, Object> findPageByParams(Integer page, Integer limit, T t)  {
        Map<String,Object> map = new HashMap<>();
        PageHelper.startPage(page,limit);
        List<T> list = baseMapper.selPageByParams(t);
        PageInfo pageInfo = new PageInfo(list);
        map.put("data",pageInfo.getList());
        map.put("count",pageInfo.getTotal());
        return map;
    }

    @Override
    public List<T> findAll() {
        List<T> list = baseMapper.selAll();
        return list;
    }

    @Override
    public String removeByPrimaryKey(Integer id)  {
        System.out.println(id);
        if (baseMapper.deleteByPrimaryKey(id)>0){
            return "success";
        }
        return "fail";
    }

    @Override
    public String removeBatchByIds(Integer[] ids) {
        if (baseMapper.deleteBatchByIds(ids)>0){
            return "success";
        }else {
            return "fail";
        }
    }

    @Override
    public String saveT(T t)  {
        if (baseMapper.insertSelective(t)>0){
            return "success";
        }else {
            return "fail";
        }
    }

    @Override
    public String updByPrimaryKeySelective(T t) {
        if (baseMapper.updateByPrimaryKeySelective(t)>0){
            return "success";
        }else {
            return "fail";
        }
    }

    @Override
    public T findTByParams(T t) {
        try {
            return baseMapper.selTByParams(t);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<T> findListTByParams(T t) {
        try {
            return baseMapper.selListTByParams(t);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String modifyBatchTByIds(T t, Integer[] ids) {
        if (baseMapper.updBatchTByIds(t,ids)>0){
            return "success";
        }else {
            return "fail";
        }
    }

    @Override
    public Long findCountByParams(T t) {
        return baseMapper.selCountByParams(t);
    }
}
