package com.gdpi.groups.controller;

import com.gdpi.groups.pojo.OrderItem;
import com.gdpi.groups.pojo.Orders;
import com.gdpi.groups.service.OrderItemService;
import com.gdpi.groups.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

/**
 * @author luojianhui
 * @date 2018/12/11
 */
@Controller
@RequestMapping("/orderItem")
public class OrderItemController {

    private final OrderItemService orderItemService;
    private final OrdersService ordersService;

    @Autowired
    public OrderItemController(OrderItemService orderItemService, OrdersService ordersService) {
        this.orderItemService = orderItemService;
        this.ordersService = ordersService;
    }

    @RequestMapping("/selOrderItem")
    public ModelAndView selOrderItem(ModelAndView modelAndView, Integer orderId) {
        List<OrderItem> orderItemList = orderItemService.selOrderItem(orderId);
        Orders orders = ordersService.selOrder(orderId);
        modelAndView.addObject("orders", orders);
        modelAndView.addObject("itemList", orderItemList);
        modelAndView.setViewName("manager/orderItem.html");
        return modelAndView;
    }
}
