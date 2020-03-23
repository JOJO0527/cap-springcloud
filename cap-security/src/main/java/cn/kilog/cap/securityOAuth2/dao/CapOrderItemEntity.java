package cn.kilog.cap.securityOAuth2.dao;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cap_order_item", schema = "cap_springcloud", catalog = "")
public class CapOrderItemEntity {
    private String id;
    private String itemId;
    private String orderId;
    private Integer num;
    private String title;
    private Long price;
    private Long totalFee;
    private String picPath;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "item_id")
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "order_id")
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "num")
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "price")
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Basic
    @Column(name = "total_fee")
    public Long getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Long totalFee) {
        this.totalFee = totalFee;
    }

    @Basic
    @Column(name = "pic_path")
    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CapOrderItemEntity that = (CapOrderItemEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(itemId, that.itemId) && Objects.equals(orderId, that.orderId) && Objects.equals(num, that.num) && Objects.equals(title, that.title) && Objects.equals(price, that.price) && Objects.equals(totalFee, that.totalFee) && Objects.equals(picPath, that.picPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemId, orderId, num, title, price, totalFee, picPath);
    }
}
