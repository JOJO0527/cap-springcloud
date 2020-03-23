package cn.kilog.cap.securityOAuth2.dao;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "config_info_beta", schema = "nacos_config", catalog = "")
public class ConfigInfoBetaEntity {
    private long id;
    private String dataId;
    private String groupId;
    private String appName;
    private String content;
    private String betaIps;
    private String md5;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private String srcUser;
    private String srcIp;
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
    @Column(name = "app_name")
    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
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
    @Column(name = "beta_ips")
    public String getBetaIps() {
        return betaIps;
    }

    public void setBetaIps(String betaIps) {
        this.betaIps = betaIps;
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
        ConfigInfoBetaEntity that = (ConfigInfoBetaEntity) o;
        return id == that.id && Objects.equals(dataId, that.dataId) && Objects.equals(groupId, that.groupId) && Objects.equals(appName, that.appName) && Objects.equals(content, that.content) && Objects.equals(betaIps, that.betaIps) && Objects.equals(md5, that.md5) && Objects.equals(gmtCreate, that.gmtCreate) && Objects.equals(gmtModified, that.gmtModified) && Objects.equals(srcUser, that.srcUser) && Objects.equals(srcIp, that.srcIp) && Objects.equals(tenantId, that.tenantId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataId, groupId, appName, content, betaIps, md5, gmtCreate, gmtModified, srcUser, srcIp, tenantId);
    }
}
