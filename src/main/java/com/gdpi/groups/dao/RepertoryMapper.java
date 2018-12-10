package com.gdpi.groups.dao;

import com.gdpi.groups.pojo.Repertory;
import com.gdpi.groups.pojo.RepertoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RepertoryMapper {
    long countByExample(RepertoryExample example);

    int deleteByExample(RepertoryExample example);

    int deleteByPrimaryKey(Integer repertoryId);

    int insert(Repertory record);

    int insertSelective(Repertory record);

    List<Repertory> selectByExample(RepertoryExample example);

    Repertory selectByPrimaryKey(Integer repertoryId);

    int updateByExampleSelective(@Param("record") Repertory record, @Param("example") RepertoryExample example);

    int updateByExample(@Param("record") Repertory record, @Param("example") RepertoryExample example);

    int updateByPrimaryKeySelective(Repertory record);

    int updateByPrimaryKey(Repertory record);
}