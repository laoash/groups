package com.gdpi.groups.service;

import com.gdpi.groups.pojo.PageResult;
import com.gdpi.groups.pojo.Result;
import com.gdpi.groups.pojo.User;

import java.util.Map;

/**
 * @author craly
 * @date 2018/12/10
 */
public interface UserService {
    /*增*/
    Result insertUser(User user);
    /*删*/
    Result deleteUser(Integer userId);
    /*改*/
    Result updateUser(User user);
    /*查(id)*/
    Result selectUserByParam(Integer userId);
    /*查 获取分页*/
    PageResult selectAllUser(Map<String, String> params);
    /*删 多条*/
    Result deleteUserMuch(Integer[] userId);
}
