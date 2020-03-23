package cn.kilog.cap.securityOAuth2.dao;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "group_capacity", schema = "nacos_config", catalog = "")
public class GroupCapacityEntity {
    private long id;
    private String groupId;
    private int quota;
    private int usage;
    private int maxSize;
    private int maxAggrCount;
    private int maxAggrSize;
    private int maxHistoryCount;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "group_id")
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "quota")
    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    @Basic
    @Column(name = "usage")
    public int getUsage() {
        return usage;
    }

    public void setUsage(int usage) {
        this.usage = usage;
    }

    @Basic
    @Column(name = "max_size")
    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Basic
    @Column(name = "max_aggr_count")
    public int getMaxAggrCount() {
        return maxAggrCount;
    }

    public void setMaxAggrCount(int maxAggrCount) {
        this.maxAggrCount = maxAggrCount;
    }

    @Basic
    @Column(name = "max_aggr_size")
    public int getMaxAggrSize() {
        return maxAggrSize;
    }

    public void setMaxAggrSize(int maxAggrSize) {
        this.maxAggrSize = maxAggrSize;
    }

    @Basic
    @Column(name = "max_history_count")
    public int getMaxHistoryCount() {
        return maxHistoryCount;
    }

    public void setMaxHistoryCount(int maxHistoryCount) {
        this.maxHistoryCount = maxHistoryCount;
    }

    @Basic
    @Column(name = "gmt_create")
    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Basic
    @Column(name = "gmt_modified")
    public Timestamp getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Timestamp gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupCapacityEntity that = (GroupCapacityEntity) o;
        return id == that.id && quota == that.quota && usage == that.usage && maxSize == that.maxSize && maxAggrCount == that.maxAggrCount && maxAggrSize == that.maxAggrSize && maxHistoryCount == that.maxHistoryCount && Objects.equals(groupId, that.groupId) && Objects.equals(gmtCreate, that.gmtCreate) && Objects.equals(gmtModified, that.gmtModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, groupId, quota, usage, maxSize, maxAggrCount, maxAggrSize, maxHistoryCount, gmtCreate, gmtModified);
    }
}
