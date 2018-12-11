package com.gdpi.groups.service;

import com.gdpi.groups.pojo.PageResult;
import com.gdpi.groups.pojo.Product;
import com.gdpi.groups.pojo.Result;

import java.util.Map;

public interface ProductService {
    /*增*/
    Result insertProduct(Product product);
    /*删*/
    Result deleteProduct(Integer productId);
    /*删  (根据类别id)*/
    Result deleteProductByCategory(Integer categoryId);
    /*改*/
    Result updateProduct(Product product);
    /*查(id)*/
    Result selectProductByParam(Integer productId);
    /*查  (根据类别d)    返回list*/
    Result selectProductByCategory(Integer categoryId);
    /*查  (根据类别d)   返回分页的*/
    PageResult selectAllProductByCategory(Map<String, String> params);
    /*查 获取分页*/
    PageResult selectAllProduct(Map<String, String> params);
    /*删 多条*/
    Result deleteProductMuch(Integer[] productId);
}
