package com.gdpi.groups.controller;

import com.gdpi.groups.pojo.PageResult;
import com.gdpi.groups.pojo.Result;
import com.gdpi.groups.pojo.User;
import com.gdpi.groups.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author luojianhui
 * @date 2018/12/10
 * 会员管理
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    /*增加用户*/
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public Result addUser(User user) {
        return service.insertUser(user);
    }

    /*删除用户*/
    @RequestMapping(value = "/delUser", method = RequestMethod.POST)
    @ResponseBody
    public Result delUser(Integer userid) {
        return service.deleteUser(userid);
    }

    /*分页查找用户*/
    @RequestMapping(value = "/searchUser/list")
    @ResponseBody
    public Result updateUser(User user){return service.updateUser(user);}
    /*查询  根据id*/
    @RequestMapping("/selUser")
    @ResponseBody
    public Result findUserById(Integer userid){return service.selectUserByParam(userid);}
    /*查询 分页*/
    @RequestMapping("/selUsers")
    @ResponseBody
    public PageResult findAllUser(@RequestParam Map<String, String> params){return service.selectAllUser(params);}
}
