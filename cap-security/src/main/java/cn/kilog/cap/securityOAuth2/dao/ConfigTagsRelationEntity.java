package cn.kilog.cap.securityOAuth2.dao;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "config_tags_relation", schema = "nacos_config", catalog = "")
public class ConfigTagsRelationEntity {
    private long id;
    private String tagName;
    private String tagType;
    private String dataId;
    private String groupId;
    private String tenantId;
    private long nid;

    @Basic
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "tag_name")
    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Basic
    @Column(name = "tag_type")
    public String getTagType() {
        return tagType;
    }

    public void setTagType(String tagType) {
        this.tagType = tagType;
    }

    @Basic
    @Column(name = "data_id")
    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
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
    @Column(name = "tenant_id")
    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    @Id
    @Column(name = "nid")
    public long getNid() {
        return nid;
    }

    public void setNid(long nid) {
        this.nid = nid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConfigTagsRelationEntity that = (ConfigTagsRelationEntity) o;
        return id == that.id && nid == that.nid && Objects.equals(tagName, that.tagName) && Objects.equals(tagType, that.tagType) && Objects.equals(dataId, that.dataId) && Objects.equals(groupId, that.groupId) && Objects.equals(tenantId, that.tenantId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tagName, tagType, dataId, groupId, tenantId, nid);
    }
}
