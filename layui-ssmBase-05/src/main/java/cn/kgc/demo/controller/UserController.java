package cn.kgc.demo.controller;

import cn.kgc.demo.pojo.Users;
import cn.kgc.demo.service.BaseService;
import cn.kgc.utils.MD5;
import cn.kgc.utils.VerifyCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    BaseService<Users> baseService;

    @RequestMapping("getVerifyCode")
    public void getVerifyCode(HttpSession session, HttpServletResponse response){
        try {
            //1.获取到随机验证码
            String verifyCode = VerifyCodeUtils.generateVerifyCode(5);
            //2.将生成的随机验证码（转为小写）放在session容器中保存起来
            session.setAttribute("verifyCode",verifyCode.toLowerCase());
            //3.将此随机验证码响应到页面中（将验证码输出图片到页面中）
            VerifyCodeUtils.outputImage(200,35,response.getOutputStream(),verifyCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("verifyCheck")
    @ResponseBody
    public String verifyCheck(String yzm,HttpSession session){
        String verifyCode = (String) session.getAttribute("verifyCode");
        if (yzm.equalsIgnoreCase(verifyCode)){
            return "success";
        }else {
            return "fail";
        }
    }

    @RequestMapping("loginUser")
    @ResponseBody
    public String loginUser(Users loginJson, HttpSession session){
        Users tByParams = baseService.findTByParams(loginJson);
        if (tByParams !=null){
            session.setAttribute("loginUser",tByParams);
            return "success";
        }else {
            return "fail";
        }
    }

    @RequestMapping("exitUser")
    @ResponseBody
    public String exitUser(HttpSession session){
        try {
            session.removeAttribute("loginUser");
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
