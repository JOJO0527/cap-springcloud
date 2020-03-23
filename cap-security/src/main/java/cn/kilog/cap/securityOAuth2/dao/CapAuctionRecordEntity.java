package cn.kilog.cap.securityOAuth2.dao;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "cap_auction_record", schema = "cap_springcloud", catalog = "")
public class CapAuctionRecordEntity {
    private int id;
    private Long userId;
    private long itemId;
    private Timestamp auctionTime;
    private long auctionPrice;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "item_id")
    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "auctionTime")
    public Timestamp getAuctionTime() {
        return auctionTime;
    }

    public void setAuctionTime(Timestamp auctionTime) {
        this.auctionTime = auctionTime;
    }

    @Basic
    @Column(name = "auctionPrice")
    public long getAuctionPrice() {
        return auctionPrice;
    }

    public void setAuctionPrice(long auctionPrice) {
        this.auctionPrice = auctionPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CapAuctionRecordEntity that = (CapAuctionRecordEntity) o;
        return id == that.id && itemId == that.itemId && auctionPrice == that.auctionPrice && Objects.equals(userId, that.userId) && Objects.equals(auctionTime, that.auctionTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, itemId, auctionTime, auctionPrice);
    }
}
