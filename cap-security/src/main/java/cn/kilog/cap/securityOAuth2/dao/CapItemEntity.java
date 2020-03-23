package cn.kilog.cap.securityOAuth2.dao;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "cap_item", schema = "cap_springcloud", catalog = "")
public class CapItemEntity {
    private long id;
    private String title;
    private String sellPoint;
    private int price;
    private int num;
    private String barcode;
    private String image;
    private long cid;
    private byte status;
    private Timestamp created;
    private Timestamp updated;
    private Long openingBid;
    private Long currentbid;
    private Timestamp countdown;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    @Column(name = "sell_point")
    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    @Basic
    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "num")
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Basic
    @Column(name = "barcode")
    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "cid")
    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }

    @Basic
    @Column(name = "status")
    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Basic
    @Column(name = "created")
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Basic
    @Column(name = "updated")
    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    @Basic
    @Column(name = "openingBid")
    public Long getOpeningBid() {
        return openingBid;
    }

    public void setOpeningBid(Long openingBid) {
        this.openingBid = openingBid;
    }

    @Basic
    @Column(name = "currentbid")
    public Long getCurrentbid() {
        return currentbid;
    }

    public void setCurrentbid(Long currentbid) {
        this.currentbid = currentbid;
    }

    @Basic
    @Column(name = "countdown")
    public Timestamp getCountdown() {
        return countdown;
    }

    public void setCountdown(Timestamp countdown) {
        this.countdown = countdown;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CapItemEntity that = (CapItemEntity) o;
        return id == that.id && price == that.price && num == that.num && cid == that.cid && status == that.status && Objects.equals(title, that.title) && Objects.equals(sellPoint, that.sellPoint) && Objects.equals(barcode, that.barcode) && Objects.equals(image, that.image) && Objects.equals(created, that.created) && Objects.equals(updated, that.updated) && Objects.equals(openingBid, that.openingBid) && Objects.equals(currentbid, that.currentbid) && Objects.equals(countdown, that.countdown);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, sellPoint, price, num, barcode, image, cid, status, created, updated, openingBid, currentbid, countdown);
    }
}
