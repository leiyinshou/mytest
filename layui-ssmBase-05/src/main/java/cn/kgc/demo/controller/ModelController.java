package cn.kgc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("model")
public class ModelController {


    @RequestMapping("toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("toHome")
    public String toHome(){
        return "home";
    }


    @RequestMapping("toSaveSale")
    public String toSaveSale(){
        return "saveSale";
    }


    @RequestMapping("toShowSale")
    public String toShowSale(){
        return "showSale";
    }


    @RequestMapping("toSelProduct")
    public String toSelProduct(){
        return "selProduct";
    }
}
