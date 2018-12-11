package com.gdpi.groups.service;

import com.gdpi.groups.pojo.OrderItem;

import java.util.List;

/**
 * @author luojianhui
 * @date 2018/12/11
 */
public interface OrderItemService {
    List<OrderItem> selOrderItem(Integer orderId);
}
