package cn.kilog.cap.securityOAuth2.dao;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "base_user", schema = "cap_springcloud", catalog = "")
public class BaseUserEntity {
    private String id;
    private String userName;
    private String userPassword;
    private String nikeName;
    private Integer status;

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "USER_NAME")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "USER_PASSWORD")
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "NIKE_NAME")
    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    @Basic
    @Column(name = "STATUS")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseUserEntity that = (BaseUserEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(userName, that.userName) && Objects.equals(userPassword, that.userPassword) && Objects.equals(nikeName, that.nikeName) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, userPassword, nikeName, status);
    }
}
