package com.gdpi.groups.pojo;

/**
 * 订单详情
 */
public class OrderItem {
    private Integer itemId;
    //订单id
    private Integer orderId;
    //商品id
    private Integer productId;
    //购买数量
    private Integer buyCount;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }
}