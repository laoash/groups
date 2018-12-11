package com.gdpi.groups.service.impl;

import com.gdpi.groups.dao.OrdersMapper;
import com.gdpi.groups.pojo.*;
import com.gdpi.groups.service.OrdersService;
import com.gdpi.groups.utils.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author luojianhui
 * @date 2018/12/11
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    private final OrdersMapper ordersMapper;

    @Autowired
    public OrdersServiceImpl(OrdersMapper ordersMapper) {
        this.ordersMapper = ordersMapper;
    }

    @Override
    public Result insertOrders(Orders orders) {
        int i = ordersMapper.insertSelective(orders);
        if (i > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.error(-1, "添加失败");
        }
    }

    @Override
    public Result deleteOrders(Integer orderId) {
        int i = ordersMapper.deleteByPrimaryKey(orderId);
        if (i > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.error(-1, "删除失败");
        }
    }

    @Override
    public Result selectOrdersByParam(Integer orderId) {
        return null;
    }

    @Override
    public PageResult selectAllOrders(Map<String, String> params) {
        // 分页处理，获取分页参数
        Integer page = new Integer(params.get("limit"));
        Integer rows = new Integer(params.get("offset"));
        PageHelper.startPage((rows / page) + 1, page);
        String ordersId = params.get("search");
        String search = null;
        if (ordersId != null && !ordersId.isEmpty()) {
            search = ordersId;
        }
        // 执行查询
        List<Orders> orders = ordersMapper.selectByExampleWithUser(search);
        // 取分页信息
        PageInfo<Orders> pageInfo = new PageInfo<>(orders);
        //结果数量
        long total = pageInfo.getTotal();
        // 返回处理结果
        return new PageResult(total, orders);
    }
}
