package com.gdpi.groups.service.impl;

import com.gdpi.groups.dao.OrderItemMapper;
import com.gdpi.groups.pojo.OrderItem;
import com.gdpi.groups.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author luojianhui
 * @date 2018/12/11
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemMapper orderItemMapper;

    @Autowired
    public OrderItemServiceImpl(OrderItemMapper orderItemMapper) {
        this.orderItemMapper = orderItemMapper;
    }

    @Override
    public List<OrderItem> selOrderItem(Integer orderId) {
        return orderItemMapper.selectByOrderId(orderId);
    }
}
