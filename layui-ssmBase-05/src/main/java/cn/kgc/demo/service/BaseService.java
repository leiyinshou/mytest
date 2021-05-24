package cn.kgc.demo.service;



import java.util.List;
import java.util.Map;

public interface BaseService<T> {

    /**
     *   根据条件分页查询数据
     * @param page  当前页
     * @param limit  每一页的数据条数
     * @param t  查询的条件
     * @return  分页插件的对象数据
     */
    Map<String,Object> findPageByParams(Integer page, Integer limit, T t) ;

    /**
     *   查询所有数据
     * @return  返回查询的数据集合
     */
    List<T> findAll() ;

    /**
     *   根据主键id删除单个数据
     * @param id  主键id
     * @return  删除操作结果
     */
    String removeByPrimaryKey(Integer id) ;

    /**
     *   根据多个主键id批量删除数据
     * @param ids  多个主键id的数组
     * @return  操作的数据条数
     */
    String removeBatchByIds(Integer[] ids) ;

    /**
     *   添加数据
     * @param t  要添加的数据
     * @return  添加的操作结果
     */
    String saveT(T t) ;

    /**
     *   动态修改数据
     * @param t 要修改的的数据对象
     * @return  修改的操作结果
     */
    String updByPrimaryKeySelective(T t) ;

    T findTByParams(T t);

    List<T> findListTByParams(T t);

    String modifyBatchTByIds(T t, Integer[] ids);

    Long findCountByParams(T t);
}
