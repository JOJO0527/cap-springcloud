package cn.kilog.cap.securityOAuth2.dao;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "config_info_aggr", schema = "nacos_config", catalog = "")
public class ConfigInfoAggrEntity {
    private long id;
    private String dataId;
    private String groupId;
    private String datumId;
    private String content;
    private Timestamp gmtModified;
    private String appName;
    private String tenantId;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    @Column(name = "datum_id")
    public String getDatumId() {
        return datumId;
    }

    public void setDatumId(String datumId) {
        this.datumId = datumId;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "gmt_modified")
    public Timestamp getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Timestamp gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Basic
    @Column(name = "app_name")
    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    @Basic
    @Column(name = "tenant_id")
    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConfigInfoAggrEntity that = (ConfigInfoAggrEntity) o;
        return id == that.id && Objects.equals(dataId, that.dataId) && Objects.equals(groupId, that.groupId) && Objects.equals(datumId, that.datumId) && Objects.equals(content, that.content) && Objects.equals(gmtModified, that.gmtModified) && Objects.equals(appName, that.appName) && Objects.equals(tenantId, that.tenantId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataId, groupId, datumId, content, gmtModified, appName, tenantId);
    }
}
