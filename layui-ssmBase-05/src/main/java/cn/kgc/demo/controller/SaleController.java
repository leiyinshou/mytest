package cn.kgc.demo.controller;

import cn.kgc.demo.pojo.Sale;
import cn.kgc.demo.pojo.Users;
import cn.kgc.demo.service.BaseService;
import cn.kgc.demo.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("sale")
public class SaleController extends BaseController<Sale> {

    @Autowired
    private SaleService saleService;

    @RequestMapping("saveSale")
    @ResponseBody
    public String save(Sale sale, HttpSession session){
        /*Object users = session.getAttribute("loginUser");
        sale.setUserid(users.getId());*/
        try {
            return saleService.saveSales(sale);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
