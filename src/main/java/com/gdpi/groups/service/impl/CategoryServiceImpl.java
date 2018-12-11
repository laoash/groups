package com.gdpi.groups.service.impl;

import com.gdpi.groups.dao.CategoryMapper;
import com.gdpi.groups.pojo.*;
import com.gdpi.groups.service.CategoryService;
import com.gdpi.groups.utils.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author craly
 * @date 2018/12/11
 */

@Service
public class CategoryServiceImpl implements CategoryService {
    private static CategoryMapper mapper;

    @Autowired
    public CategoryServiceImpl(CategoryMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Result insertCategory(Category category) {
        int i = mapper.insertSelective(category);
        if (i > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.error(-1, "添加失败");
        }
    }

    @Override
    public Result deleteCategory(Integer categoryId) {
        int i = mapper.deleteByPrimaryKey(categoryId);
        if (i > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.error(-1, "删除失败");
        }
    }

    @Override
    public Result deleteCategoryByFather(Integer fatherId) {
        CategoryExample example = new CategoryExample();
        CategoryExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(fatherId);
        int i = mapper.deleteByExample(example);
        if (i > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.error(-1, "删除失败");
        }
    }

    @Override
    public Result updateCategory(Category category) {
        int i = mapper.updateByPrimaryKeySelective(category);
        if (i > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.error(-1, "修改失败");
        }
    }

    @Override
    public Result selectCategoryByParam(Integer categoryId) {
        Category category = mapper.selectByPrimaryKey(categoryId);
       if(category!=null){
           return ResultUtil.success(category);
       }else{
           return ResultUtil.error(-1, "查询失败");
       }
    }

    @Override
    public Result selectCategoryByFather(Integer fatherId) {
        CategoryExample example = new CategoryExample();
        CategoryExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(fatherId);
        List<Category> list = mapper.selectByExample(example);
       if(list.size()!=0&&list!=null){
           return ResultUtil.success(list);
       }else{
           return ResultUtil.error(-1, "查询失败");
       }
    }

    @Override
    public PageResult selectAllCategory(Map<String, String> params) {
        // 分页处理，获取分页参数
        Integer page = new Integer(params.get("limit"));
        Integer rows = new Integer(params.get("offset"));
        PageHelper.startPage((rows / page) + 1, page);
        String csName = params.get("search");
        //创建Expert对象
        CategoryExample example = new CategoryExample();
        if (csName != null && csName != "") {
            CategoryExample.Criteria criteria = example.createCriteria();
            criteria.andCsNameLike('%' + csName + '%');
        }
        // 执行查询
        List<Category> allCategory = mapper.selectByExample(example);
        // 取分页信息
        PageInfo<Category> pageInfo = new PageInfo<>(allCategory);
        //结果数量
        long total = pageInfo.getTotal();
        // 返回处理结果
        return new PageResult(total, allCategory);
    }

    @Override
    public Result deleteCategoryMuch(Integer[] categoryId) {
        List<Integer> list = new ArrayList<>();
        for (Integer i : categoryId) {
            list.add(i);
        }
        CategoryExample example = new CategoryExample();
        CategoryExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdIn(list);
        int i = mapper.deleteByExample(example);
        if (i > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.error(-1, "删除失败");
        }
    }
}
