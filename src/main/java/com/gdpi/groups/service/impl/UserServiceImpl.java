package com.gdpi.groups.service.impl;

import com.gdpi.groups.dao.UserMapper;
import com.gdpi.groups.pojo.PageResult;
import com.gdpi.groups.pojo.Result;
import com.gdpi.groups.pojo.User;
import com.gdpi.groups.pojo.UserExample;
import com.gdpi.groups.service.UserService;
import com.gdpi.groups.utils.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper mapper;

    @Autowired
    public UserServiceImpl(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Result insertUser(User user) {
        int i = mapper.insertSelective(user);
        if (i > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.error(-1, "添加失败");
        }
    }

    @Override
    public Result deleteUser(Integer userId) {
        int i = mapper.deleteByPrimaryKey(userId);
        if (i > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.error(-1, "删除失败");
        }
    }

    @Override
    public Result updateUser(User user) {
        int i = mapper.updateByPrimaryKeySelective(user);
        if (i > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.error(-1, "修改失败");
        }
    }

    @Override
    public Result selectUserByParam(Integer userId) {
        User res = mapper.selectByPrimaryKey(userId);
        if (res != null) {
            return ResultUtil.success(res);
        } else {
            return ResultUtil.error(-1, "查找失败");
        }
    }

    @Override
    public PageResult selectAllUser(Map<String, String> params) {
        // 分页处理，获取分页参数
        Integer page = new Integer(params.get("limit"));
        Integer rows = new Integer(params.get("offset"));
        PageHelper.startPage((rows / page) + 1, page);
        String userName = params.get("search");
        //创建Expert对象
        UserExample example = new UserExample();
        if (userName != null && userName != "") {
            UserExample.Criteria criteria = example.createCriteria();
            criteria.andUserNameLike('%' + userName + '%');
        }
        // 执行查询
        List<User> allUser = mapper.selectByExample(example);
        // 取分页信息
        PageInfo<User> pageInfo = new PageInfo<>(allUser);
        //结果数量
        long total = pageInfo.getTotal();
        // 返回处理结果
        return new PageResult(total, allUser);
    }

    @Override
    public Result deleteUserMuch(Integer[] userId) {
        List<Integer> list = new ArrayList<>();
        for (Integer i : userId) {
            list.add(i);
        }
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdIn(list);
        int i = mapper.deleteByExample(example);
        if (i > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.error(-1, "删除失败");
        }
    }
}
