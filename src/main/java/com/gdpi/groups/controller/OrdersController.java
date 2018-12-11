package com.gdpi.groups.controller;

import com.gdpi.groups.pojo.Orders;
import com.gdpi.groups.pojo.PageResult;
import com.gdpi.groups.pojo.Result;
import com.gdpi.groups.pojo.User;
import com.gdpi.groups.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author luojianhui
 * @date 2018/12/11
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {

    private final OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }
    /*增加用户*/
    @RequestMapping(value = "/addOrders", method = RequestMethod.POST)
    @ResponseBody
    public Result addOrders(Orders orders) {
        return ordersService.insertOrders(orders);
    }

    /*删除用户*/
    @RequestMapping(value = "/delOrders", method = RequestMethod.POST)
    @ResponseBody
    public Result delOrders(Integer orderId) {
        return ordersService.deleteOrders(orderId);
    }

//    /*查询  根据id*/
//    @RequestMapping("/selOrders")
//    @ResponseBody
//    public Result findOrdersById(Integer orderId) {
//        return ordersService.selectOrdersByParam(orderId);
//    }

    /*查询 分页*/
    @RequestMapping("/selOrders")
    @ResponseBody
    public PageResult findAllOrders(@RequestParam Map<String, String> params) {
        return ordersService.selectAllOrders(params);
    }
}
