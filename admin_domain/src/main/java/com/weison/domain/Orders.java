package com.weison.domain;

import com.weison.util.DateUtil;

import java.util.Date;
import java.util.List;

public class Orders {

    private String id;                          // 订单id 随机唯一
    private String orderNum;                    // 订单编号 唯一
    private Date orderTime;                     // 下单时间
    private String orderTimeStr;                // 下单时间 String
    private int orderStatus;                    // 订单状态
    private int peopleCount;                    // 人数
    private Product product;                    // 订单产品
    private List<Traveller> travellers;         // 旅游人数
    private Member member;                      // 下单会员
    private Integer payType;                    // 付款方式
    private String payTypeStr;                  // 付款方式
    private String orderDesc;                   // 订单简述


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        if (getOrderTime() != null){
            setOrderTimeStr(DateUtil.Date2Str(getOrderTime(),"yyyy-MM-dd HH:mm"));
        }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeStr() {
        if (getPayType() == 0) {
            setPayTypeStr("支付宝");
        } else if (getPayType() == 1) {
            setPayTypeStr("微信");
        } else {
            setPayTypeStr("其他");
        }
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }
}
