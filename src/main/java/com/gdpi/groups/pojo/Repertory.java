package com.gdpi.groups.pojo;

public class Repertory {
    private Integer repertoryId;
    //库存数量
    private Integer repertoryCount;
    //产品id
    private Integer productId;

    public Integer getRepertoryId() {
        return repertoryId;
    }

    public void setRepertoryId(Integer repertoryId) {
        this.repertoryId = repertoryId;
    }

    public Integer getRepertoryCount() {
        return repertoryCount;
    }

    public void setRepertoryCount(Integer repertoryCount) {
        this.repertoryCount = repertoryCount;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}