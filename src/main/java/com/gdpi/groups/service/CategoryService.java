package com.gdpi.groups.service;


import com.gdpi.groups.pojo.Category;
import com.gdpi.groups.pojo.PageResult;
import com.gdpi.groups.pojo.Result;

import java.util.Map;

/**
 * @author craly
 * @date 2018/12/11
 */
public interface CategoryService {
    /*增*/
    Result insertCategory(Category category);
    /*删*/
    Result deleteCategory(Integer categoryId);
    /*删  (根据父id)*/
    Result deleteCategoryByFather(Integer fatherId);
    /*改*/
    Result updateCategory(Category category);
    /*查(id)*/
    Result selectCategoryByParam(Integer categoryId);
    /*查  (根据父id)*/
    Result selectCategoryByFather(Integer fatherId);
    /*查 获取分页*/
    PageResult selectAllCategory(Map<String, String> params);
    /*删 多条*/
    Result deleteCategoryMuch(Integer[] categoryId);
}
