package org.wsh.controller.developer;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wsh.pojo.DevUser;
import org.wsh.service.developer.DevUserDaoService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/dev")
public class DeveloperController {

    @Resource
    private DevUserDaoService devuserDaoService;

//    从index页面跳转到用户登录界面
    @RequestMapping("/showlogin")
    public String showlogin(){
       return "devlogin";
    }

    @RequestMapping("/Login")
    public String Login(ModelMap map, String devCode, String devPassword){

        DevUser devuser = devuserDaoService.findByDevName(devCode);

        if (!devuser.getDevPassword().equals(devPassword)){
            return "devlogin";
        }else{
            map.addAttribute("devUserSession",devuser);
            return "/dev/main";

        }

    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("devUserSession");
        session.invalidate();
        return "devlogin";
    }
}
