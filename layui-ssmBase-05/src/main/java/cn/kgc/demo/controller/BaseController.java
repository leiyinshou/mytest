package cn.kgc.demo.controller;

import cn.kgc.demo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

public class BaseController<T> {

    @Autowired
    private BaseService<T> baseService;

    @RequestMapping("loadPageByParams")
    @ResponseBody
    public Map<String,Object> loadPageByParams(Integer page, Integer limit, T t){
        Map<String,Object> map = null;
        System.out.println(t);
        try {
            map = baseService.findPageByParams(page,limit,t);
            map.put("code",0);
            map.put("msg","数据请求成功");
        } catch (Exception e) {
            map.put("code",200);
            map.put("msg","数据请求失败");
            e.printStackTrace();
        }
        System.out.println(map);
        return map;
    }

    @RequestMapping("delByPrimaryKey")
    @ResponseBody
    public String delByPrimaryKey(Integer id){
        try {
            return baseService.removeByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping("delBatchByIds")
    @ResponseBody
    public String delBatchByIds(Integer[] ids){
        try {
            return baseService.removeBatchByIds(ids);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping("save")
    @ResponseBody
    public String save(T t){
        try {
            return baseService.saveT(t);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping("updByPrimaryKeySelective")
    @ResponseBody
    public String updByPrimaryKeySelective(T t){
        try {
            return baseService.updByPrimaryKeySelective(t);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping("loadAll")
    @ResponseBody
    public List<T> loadAll(){
        try {
            return baseService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("loadTByParams")
    @ResponseBody
    public T loadTByParams(T t){
        try {
            return baseService.findTByParams(t);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("loadListTByParams")
    @ResponseBody
    public List<T> loadListTByParams(T t){
        try {
            return baseService.findListTByParams(t);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("updBatchTByIds")
    @ResponseBody
    public String updBatchTByIds(T t,Integer[] ids){
        try {
            return baseService.modifyBatchTByIds(t,ids);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping("getCountByParams")
    @ResponseBody
    public Long getCountByParams(T t){
        try {
            return baseService.findCountByParams(t);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
