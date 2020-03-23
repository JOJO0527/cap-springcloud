package cn.kilog.cap.securityOAuth2.dao;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "base_role", schema = "cap_springcloud", catalog = "")
public class BaseRoleEntity {
    private String id;
    private String roleCode;
    private String roleName;

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ROLE_CODE")
    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    @Basic
    @Column(name = "ROLE_NAME")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseRoleEntity that = (BaseRoleEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(roleCode, that.roleCode) && Objects.equals(roleName, that.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleCode, roleName);
    }
}
