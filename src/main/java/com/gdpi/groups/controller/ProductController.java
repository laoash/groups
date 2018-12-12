package com.gdpi.groups.controller;


import com.gdpi.groups.pojo.PageResult;
import com.gdpi.groups.pojo.Product;
import com.gdpi.groups.pojo.Result;
import com.gdpi.groups.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author craly
 * @date 2018/12/11
 * 商品管理
 */
@Controller
@RequestMapping("/prod")
public class ProductController {
    private ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    /*增*/
    @RequestMapping(value = "/addProd", method = RequestMethod.POST)
    @ResponseBody
    public Result addProduct(Product product) {
        return service.insertProduct(product);
    }

    /*删*/
    @RequestMapping(value = "/delProd", method = RequestMethod.POST)
    @ResponseBody
    public Result delProduct(Integer productid) {
        return service.deleteProduct(productid);
    }

    /*删  (根据类别id)*/
    @RequestMapping(value = "/delPByC", method = RequestMethod.POST)
    @ResponseBody
    public Result delProductByCategory(Integer categoryId) {
        return service.deleteProductByCategory(categoryId);
    }

    /*删 多条*/
    @RequestMapping(value = "/delProds", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteProductMuch(@RequestParam("productid[]") Integer[] productid) {
        return service.deleteProductMuch(productid);
    }

    /*改*/
    @RequestMapping(value = "/updProd", method = RequestMethod.POST)
    @ResponseBody
    public Result updateProduct(Product product) {
        return service.updateProduct(product);
    }

    /*查(id)*/
    @RequestMapping("/selProd")
    @ResponseBody
    public Result findProductById(Integer productid) {
        return service.selectProductByParam(productid);
    }

    /*查  (根据类别d)   返回分页的*/
    @RequestMapping("/selPByC")
    @ResponseBody
    public PageResult findAllProductByCategory(@RequestParam Map<String, String> params) {
        return service.selectAllProductByCategory(params);
    }

    /*查  (根据类别d)   返回是不分页的*/
    @RequestMapping("/selPByCList")
    @ResponseBody
    public Result findProductByCategory(Integer categoryId) {
        return service.selectProductByCategory(categoryId);
    }
    /*查 获取分页*/

    @RequestMapping("/selProds")
    @ResponseBody
    public PageResult findAllProduct(@RequestParam Map<String, String> params) {
        return service.selectAllProduct(params);
    }
}
