package cn.kilog.cap.securityOAuth2.dao;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "config_info", schema = "nacos_config", catalog = "")
public class ConfigInfoEntity {
    private long id;
    private String dataId;
    private String groupId;
    private String content;
    private String md5;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private String srcUser;
    private String srcIp;
    private String appName;
    private String tenantId;
    private String cDesc;
    private String cUse;
    private String effect;
    private String type;
    private String cSchema;

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
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "md5")
    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
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

    @Basic
    @Column(name = "src_user")
    public String getSrcUser() {
        return srcUser;
    }

    public void setSrcUser(String srcUser) {
        this.srcUser = srcUser;
    }

    @Basic
    @Column(name = "src_ip")
    public String getSrcIp() {
        return srcIp;
    }

    public void setSrcIp(String srcIp) {
        this.srcIp = srcIp;
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

    @Basic
    @Column(name = "c_desc")
    public String getcDesc() {
        return cDesc;
    }

    public void setcDesc(String cDesc) {
        this.cDesc = cDesc;
    }

    @Basic
    @Column(name = "c_use")
    public String getcUse() {
        return cUse;
    }

    public void setcUse(String cUse) {
        this.cUse = cUse;
    }

    @Basic
    @Column(name = "effect")
    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "c_schema")
    public String getcSchema() {
        return cSchema;
    }

    public void setcSchema(String cSchema) {
        this.cSchema = cSchema;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConfigInfoEntity that = (ConfigInfoEntity) o;
        return id == that.id && Objects.equals(dataId, that.dataId) && Objects.equals(groupId, that.groupId) && Objects.equals(content, that.content) && Objects.equals(md5, that.md5) && Objects.equals(gmtCreate, that.gmtCreate) && Objects.equals(gmtModified, that.gmtModified) && Objects.equals(srcUser, that.srcUser) && Objects.equals(srcIp, that.srcIp) && Objects.equals(appName, that.appName) && Objects.equals(tenantId, that.tenantId) && Objects.equals(cDesc, that.cDesc) && Objects.equals(cUse, that.cUse) && Objects.equals(effect, that.effect) && Objects.equals(type, that.type) && Objects.equals(cSchema, that.cSchema);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataId, groupId, content, md5, gmtCreate, gmtModified, srcUser, srcIp, appName, tenantId, cDesc, cUse, effect, type, cSchema);
    }
}
