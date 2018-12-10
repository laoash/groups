package com.gdpi.groups.pojo;

import java.util.List;

public class PageResult {

	private Integer total;
	
	private List<?> rows;
	
	public PageResult(Integer total, List<?> rows) {
		this.total = total;
		this.rows = rows;
	}
	
	public PageResult(long total, List<?> rows) {
		this.total = (int) total;
		this.rows = rows;
	}

	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
	
}
