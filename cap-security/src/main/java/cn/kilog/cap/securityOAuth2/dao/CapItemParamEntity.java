package cn.kilog.cap.securityOAuth2.dao;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "cap_item_param", schema = "cap_springcloud", catalog = "")
public class CapItemParamEntity {
    private long id;
    private Long itemCatId;
    private String paramData;
    private Timestamp created;
    private Timestamp updated;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "item_cat_id")
    public Long getItemCatId() {
        return itemCatId;
    }

    public void setItemCatId(Long itemCatId) {
        this.itemCatId = itemCatId;
    }

    @Basic
    @Column(name = "param_data")
    public String getParamData() {
        return paramData;
    }

    public void setParamData(String paramData) {
        this.paramData = paramData;
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
        CapItemParamEntity that = (CapItemParamEntity) o;
        return id == that.id && Objects.equals(itemCatId, that.itemCatId) && Objects.equals(paramData, that.paramData) && Objects.equals(created, that.created) && Objects.equals(updated, that.updated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemCatId, paramData, created, updated);
    }
}
