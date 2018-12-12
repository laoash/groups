package com.gdpi.groups.service.impl;

import com.gdpi.groups.dao.ProductMapper;
import com.gdpi.groups.pojo.PageResult;
import com.gdpi.groups.pojo.Product;
import com.gdpi.groups.pojo.ProductExample;
import com.gdpi.groups.pojo.Result;
import com.gdpi.groups.service.ProductService;
import com.gdpi.groups.utils.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author craly
 * @date 2018/12/11
 */
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductMapper mapper;

    @Autowired
    public ProductServiceImpl(ProductMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Result insertProduct(Product product) {
        int i = mapper.insertSelective(product);
        if (i > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.error(-1, "添加失败");
        }
    }

    @Override
    public Result deleteProduct(Integer productId) {
        int i = mapper.deleteByPrimaryKey(productId);
        if (i > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.error(-1, "删除失败");
        }
    }

    @Override
    public Result deleteProductByCategory(Integer categoryId) {
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        criteria.andProductIdEqualTo(categoryId);
        int i = mapper.deleteByExample(example);
        if (i > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.error(-1, "删除失败");
        }
    }

    @Override
    public Result updateProduct(Product product) {
        int i = mapper.updateByPrimaryKeySelective(product);
        if (i > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.error(-1, "修改失败");
        }
    }

    @Override
    public Result selectProductByParam(Integer productId) {
        Product product = mapper.selectByPrimaryKey(productId);
        if (product != null) {
            return ResultUtil.success(product);
        } else {
            return ResultUtil.error(-1, "查询失败");
        }
    }

    @Override
    public Result selectProductByCategory(Integer categoryId) {
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        criteria.andProductIdEqualTo(categoryId);
        List<Product> list = mapper.selectByExample(example);
        if (list.size() != 0 && list != null) {
            return ResultUtil.success(list);
        } else {
            return ResultUtil.error(-1, "查询失败");
        }
    }

    @Override
    public PageResult selectAllProductByCategory(Map<String, String> params) {
        // 分页处理，获取分页参数
        Integer categoryId = new Integer(params.get("categoryId"));
        Integer page = new Integer(params.get("limit"));
        Integer rows = new Integer(params.get("offset"));
        PageHelper.startPage((rows / page) + 1, page);
        //创建Expert对象
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId);
        // 执行查询
        List<Product> allProduct = mapper.selectByExample(example);
        // 取分页信息
        PageInfo<Product> pageInfo = new PageInfo<>(allProduct);
        //结果数量
        long total = pageInfo.getTotal();
        // 返回处理结果
        return new PageResult(total, allProduct);
    }

    @Override
    public PageResult selectAllProduct(Map<String, String> params) {
        // 分页处理，获取分页参数
        Integer page = new Integer(params.get("limit"));
        Integer rows = new Integer(params.get("offset"));
        PageHelper.startPage((rows / page) + 1, page);
        String productName = params.get("search");
        //创建Expert对象
        ProductExample example = new ProductExample();
        if (productName != null && !productName.isEmpty()) {
            ProductExample.Criteria criteria = example.createCriteria();
            criteria.andProductNameLike('%' + productName + '%');
        }
        // 执行查询
        List<Product> allProduct = mapper.selectByExample(example);
        // 取分页信息
        PageInfo<Product> pageInfo = new PageInfo<>(allProduct);
        //结果数量
        long total = pageInfo.getTotal();
        // 返回处理结果
        return new PageResult(total, allProduct);
    }

    @Override
    public Result deleteProductMuch(Integer[] productId) {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(productId));
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        criteria.andProductIdIn(list);
        int i = mapper.deleteByExample(example);
        if (i > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.error(-1, "删除失败");
        }
    }
}
