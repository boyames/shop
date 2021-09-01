package com.test.controller;

import com.test.pojo.Users;
import com.test.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUsersService usersService;

    public IUsersService getUsersService(){
        return usersService;
    }

    @RequestMapping("/regUi")
    public String regUi(){

        return "register";
    }

    @RequestMapping("/reg")
    public String reg(Users users){

        //存入数据库
        int i=usersService.reg(users);
//        System.out.println(i);
//        return "success";
        if(i>0)
            return "login";
        else
            return "error";

    }

    @RequestMapping("/isExistsUname")
    public String isExistsUname(String uname){

        int i=usersService.isExistsUname(uname);
        return i+"";//拼一个空串，返回String 传到js文件（String类型）
    }

    //进入登入界面
    @RequestMapping("/loginUi")
    public String loginUi(){
        return "login";
    }

    @RequestMapping("/checkLogin")
    public String checkLogin(Users users, HttpServletRequest request){
        //判断用户名和密码是否正确
        Users loginUser = usersService.login(users);
        //如果登入成功
        if (loginUser!=null){
            HttpSession session = request.getSession();

            session.setAttribute("loginUser",loginUser);

            return "redirect:/index/index";
        }
        else {
                return "loginError";
        }
    }
    //退出登入
    @RequestMapping("/logOut")
    public String logOut(HttpServletRequest request){

        //销毁session
        HttpSession session = request.getSession();

        session.invalidate();//销毁

        //回到首页
        return "redirect:/index/index";
    }
}
