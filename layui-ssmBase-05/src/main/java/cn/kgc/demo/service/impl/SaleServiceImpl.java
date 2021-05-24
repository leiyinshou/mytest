package cn.kgc.demo.service.impl;

import cn.kgc.demo.dao.ProductMapper;
import cn.kgc.demo.dao.SaleMapper;
import cn.kgc.demo.pojo.Product;
import cn.kgc.demo.pojo.Sale;
import cn.kgc.demo.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional(readOnly = false)
public class SaleServiceImpl extends BaseServiceImpl<Sale> implements SaleService {

    @Autowired
    private SaleMapper saleMapper;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public String saveSales(Sale sale) {
        sale.setSaledate(new Date());
        //sale.setUserid(1);
        sale.setTotalprice(sale.getPrice()*sale.getQuantity());
        int saveCount = saleMapper.insertSelective(sale);
        Product updProduct = new Product();
        Product product = productMapper.selectByPrimaryKey(sale.getProductid());
        int updCount=0;
        if (product.getQuantity()>=sale.getQuantity()){
            updProduct.setId(sale.getProductid());
            updProduct.setQuantity(product.getQuantity()-sale.getQuantity());
            updCount = productMapper.updateByPrimaryKeySelective(updProduct);
        }
        if (saveCount>0 && updCount>0){
            return "success";
        }else {
            int i = 1/0;
            return "fail";
        }
    }
}
