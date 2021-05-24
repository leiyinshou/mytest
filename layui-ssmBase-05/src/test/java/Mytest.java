import cn.kgc.demo.dao.BaseMapper;
import cn.kgc.demo.pojo.Product;
import cn.kgc.demo.pojo.Sale;
import cn.kgc.demo.service.ProductService;
import cn.kgc.demo.service.SaleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//指定在单元测试启动的时候创建spring的工厂类对象
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
//RunWith的value属性指定以spring test的SpringJUnit4ClassRunner作为启动类
//如果不指定启动类，默认启用的junit中的默认启动类
@RunWith(value = SpringJUnit4ClassRunner.class)
public class Mytest {

    @Autowired
    private SaleService saleService;

    @Autowired
    private ProductService productService;

@Test
    public void fun1(){
    Sale sale = new Sale();
    sale.setUserid(1);
    sale.setPrice(3.0);
    sale.setProductid(1);
    sale.setQuantity(10);
    String s = saleService.saveSales(sale);
    System.out.println(s);
}

    @Test
    public void fun2(){
        Product p = new Product();
        p.setId(1);
        List<Product> listTByParams = productService.findListTByParams(p);
        System.out.println(listTByParams);
    }

}
