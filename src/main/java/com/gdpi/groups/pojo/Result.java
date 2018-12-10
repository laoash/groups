package com.gdpi.groups.pojo;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author luojianhui
 * @date 2018/4/27
 */

/**
 * 修改
 * <p>Title: Result</p>  
 * <p>Description: </p>  
 * @author craly  
 * @date 2018年6月18日
 */
public class Result {
	
	/**
	 * 定义jackson对象
	 */
	public static final ObjectMapper MAPPER = new ObjectMapper();
    /**
     * 错误码.
     */
    private Integer code;

    /**
     * 提示信息.
     */
    private String msg;

    /**
     * 具体的内容.
     */
    private Object data;
    
    
	public Result() {
		super();
	}

	public Result(Integer code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
