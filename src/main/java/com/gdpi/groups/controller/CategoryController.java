package com.gdpi.groups.controller;


import com.gdpi.groups.pojo.Category;
import com.gdpi.groups.pojo.PageResult;
import com.gdpi.groups.pojo.Result;
import com.gdpi.groups.service.CategoryService;
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
 * 分类管理
 */
@Controller
@RequestMapping("/cate")
public class CategoryController {
    private CategoryService service;

    @Autowired
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    /**
     * 增
     */
    @RequestMapping(value = "/addCate", method = RequestMethod.POST)
    @ResponseBody
    public Result addCategory(Category Category) {
        return service.insertCategory(Category);
    }

    /**
     * 删
     */
    @RequestMapping(value = "/delCate", method = RequestMethod.POST)
    @ResponseBody
    public Result delCategory(Integer Categoryid) {
        return service.deleteCategory(Categoryid);
    }

    /**
     * 删  (根据父id)
     */
    @RequestMapping(value = "/delCByF", method = RequestMethod.POST)
    @ResponseBody
    public Result delCategoryByCategory(Integer fatherId) {
        return service.deleteCategoryByFather(fatherId);
    }

    /**
     * 删 多条
     */
    @RequestMapping(value = "/delCates", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteCategoryMuch(@RequestParam("Categoryid[]") Integer[] Categoryid) {
        return service.deleteCategoryMuch(Categoryid);
    }

    /**
     * 改
     */
    @RequestMapping(value = "/updCate", method = RequestMethod.POST)
    @ResponseBody
    public Result updateCategory(Category Category) {
        return service.updateCategory(Category);
    }

    /**
     * 查(id)
     */
    @RequestMapping("/selCate")
    @ResponseBody
    public Result findCategoryById(Integer Categoryid) {
        return service.selectCategoryByParam(Categoryid);
    }

    /**
     * 查  (根据父d)
     */
    @RequestMapping("/selCByF")
    @ResponseBody
    public Result findCategoryByCategory(Integer fatherId) {
        return service.selectCategoryByFather(fatherId);
    }

    /**
     * 查 获取分页
     */
    @RequestMapping("/selCates")
    @ResponseBody
    public PageResult findAllCategory(@RequestParam Map<String, String> params) {
        return service.selectAllCategory(params);
    }
}
