package cn.kilog.cap.securityOAuth2.dao;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "cap_item_desc", schema = "cap_springcloud", catalog = "")
public class CapItemDescEntity {
    private long itemId;
    private String itemDesc;
    private Timestamp created;
    private Timestamp updated;

    @Id
    @Column(name = "item_id")
    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "item_desc")
    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CapItemDescEntity that = (CapItemDescEntity) o;
        return itemId == that.itemId && Objects.equals(itemDesc, that.itemDesc) && Objects.equals(created, that.created) && Objects.equals(updated, that.updated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, itemDesc, created, updated);
    }
}
