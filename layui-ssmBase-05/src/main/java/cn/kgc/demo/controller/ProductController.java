package cn.kgc.demo.controller;

import cn.kgc.demo.pojo.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("product")
public class ProductController extends BaseController<Product>{


}
