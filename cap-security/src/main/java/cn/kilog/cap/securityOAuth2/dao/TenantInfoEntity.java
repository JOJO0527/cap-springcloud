package cn.kilog.cap.securityOAuth2.dao;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tenant_info", schema = "nacos_config", catalog = "")
public class TenantInfoEntity {
    private long id;
    private String kp;
    private String tenantId;
    private String tenantName;
    private String tenantDesc;
    private String createSource;
    private long gmtCreate;
    private long gmtModified;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "kp")
    public String getKp() {
        return kp;
    }

    public void setKp(String kp) {
        this.kp = kp;
    }

    @Basic
    @Column(name = "tenant_id")
    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    @Basic
    @Column(name = "tenant_name")
    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    @Basic
    @Column(name = "tenant_desc")
    public String getTenantDesc() {
        return tenantDesc;
    }

    public void setTenantDesc(String tenantDesc) {
        this.tenantDesc = tenantDesc;
    }

    @Basic
    @Column(name = "create_source")
    public String getCreateSource() {
        return createSource;
    }

    public void setCreateSource(String createSource) {
        this.createSource = createSource;
    }

    @Basic
    @Column(name = "gmt_create")
    public long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Basic
    @Column(name = "gmt_modified")
    public long getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(long gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TenantInfoEntity that = (TenantInfoEntity) o;
        return id == that.id && gmtCreate == that.gmtCreate && gmtModified == that.gmtModified && Objects.equals(kp, that.kp) && Objects.equals(tenantId, that.tenantId) && Objects.equals(tenantName, that.tenantName) && Objects.equals(tenantDesc, that.tenantDesc) && Objects.equals(createSource, that.createSource);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, kp, tenantId, tenantName, tenantDesc, createSource, gmtCreate, gmtModified);
    }
}
