package cn.kilog.cap.securityOAuth2.dao;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "cap_order", schema = "cap_springcloud", catalog = "")
public class CapOrderEntity {
    private String orderId;
    private String payment;
    private Integer paymentType;
    private String postFee;
    private Integer status;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Timestamp paymentTime;
    private Timestamp consignTime;
    private Timestamp endTime;
    private Timestamp closeTime;
    private String shippingName;
    private String shippingCode;
    private Long userId;
    private String buyerMessage;
    private String buyerNick;
    private Integer buyerRate;

    @Id
    @Column(name = "order_id")
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "payment")
    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    @Basic
    @Column(name = "payment_type")
    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    @Basic
    @Column(name = "post_fee")
    public String getPostFee() {
        return postFee;
    }

    public void setPostFee(String postFee) {
        this.postFee = postFee;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "payment_time")
    public Timestamp getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Timestamp paymentTime) {
        this.paymentTime = paymentTime;
    }

    @Basic
    @Column(name = "consign_time")
    public Timestamp getConsignTime() {
        return consignTime;
    }

    public void setConsignTime(Timestamp consignTime) {
        this.consignTime = consignTime;
    }

    @Basic
    @Column(name = "end_time")
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "close_time")
    public Timestamp getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Timestamp closeTime) {
        this.closeTime = closeTime;
    }

    @Basic
    @Column(name = "shipping_name")
    public String getShippingName() {
        return shippingName;
    }

    public void setShippingName(String shippingName) {
        this.shippingName = shippingName;
    }

    @Basic
    @Column(name = "shipping_code")
    public String getShippingCode() {
        return shippingCode;
    }

    public void setShippingCode(String shippingCode) {
        this.shippingCode = shippingCode;
    }

    @Basic
    @Column(name = "user_id")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "buyer_message")
    public String getBuyerMessage() {
        return buyerMessage;
    }

    public void setBuyerMessage(String buyerMessage) {
        this.buyerMessage = buyerMessage;
    }

    @Basic
    @Column(name = "buyer_nick")
    public String getBuyerNick() {
        return buyerNick;
    }

    public void setBuyerNick(String buyerNick) {
        this.buyerNick = buyerNick;
    }

    @Basic
    @Column(name = "buyer_rate")
    public Integer getBuyerRate() {
        return buyerRate;
    }

    public void setBuyerRate(Integer buyerRate) {
        this.buyerRate = buyerRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CapOrderEntity that = (CapOrderEntity) o;
        return Objects.equals(orderId, that.orderId) && Objects.equals(payment, that.payment) && Objects.equals(paymentType, that.paymentType) && Objects.equals(postFee, that.postFee) && Objects.equals(status, that.status) && Objects.equals(createTime, that.createTime) && Objects.equals(updateTime, that.updateTime) && Objects.equals(paymentTime, that.paymentTime) && Objects.equals(consignTime, that.consignTime) && Objects.equals(endTime, that.endTime) && Objects.equals(closeTime, that.closeTime) && Objects.equals(shippingName, that.shippingName) && Objects.equals(shippingCode, that.shippingCode) && Objects.equals(userId, that.userId) && Objects.equals(buyerMessage, that.buyerMessage) && Objects.equals(buyerNick, that.buyerNick) && Objects.equals(buyerRate, that.buyerRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, payment, paymentType, postFee, status, createTime, updateTime, paymentTime, consignTime, endTime, closeTime, shippingName, shippingCode, userId, buyerMessage, buyerNick, buyerRate);
    }
}
