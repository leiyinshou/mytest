package cn.kgc.demo.service;

import cn.kgc.demo.pojo.Sale;

public interface SaleService extends BaseService<Sale> {
    String saveSales(Sale sale);
}
