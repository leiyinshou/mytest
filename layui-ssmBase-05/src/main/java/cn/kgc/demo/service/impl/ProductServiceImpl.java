package cn.kgc.demo.service.impl;

import cn.kgc.demo.pojo.Product;
import cn.kgc.demo.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = false)
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {
}
