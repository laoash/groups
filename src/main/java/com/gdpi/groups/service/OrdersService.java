package com.gdpi.groups.service;

import com.gdpi.groups.pojo.Orders;
import com.gdpi.groups.pojo.PageResult;
import com.gdpi.groups.pojo.Result;

import java.util.Map;

/**
 * @author luojianhui
 * @date 2018/12/11
 */
public interface OrdersService {
    Result insertOrders(Orders orders);

    Result deleteOrders(Integer orderId);

    Result selectOrdersByParam(Integer orderId);

    PageResult selectAllOrders(Map<String, String> params);

    Orders selOrder(Integer orderId);
}
