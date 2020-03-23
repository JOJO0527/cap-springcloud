package cn.kilog.cap.securityOAuth2.dao;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "base_menu", schema = "cap_springcloud", catalog = "")
public class BaseMenuEntity {
    private String id;
    private String menuUrl;
    private String menuSeq;
    private Integer menuParentId;
    private String menuName;
    private String menuIcon;
    private String menuOrder;
    private String isLeaf;

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "MENU_URL")
    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    @Basic
    @Column(name = "MENU_SEQ")
    public String getMenuSeq() {
        return menuSeq;
    }

    public void setMenuSeq(String menuSeq) {
        this.menuSeq = menuSeq;
    }

    @Basic
    @Column(name = "MENU_PARENT_ID")
    public Integer getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(Integer menuParentId) {
        this.menuParentId = menuParentId;
    }

    @Basic
    @Column(name = "MENU_NAME")
    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Basic
    @Column(name = "MENU_ICON")
    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    @Basic
    @Column(name = "MENU_ORDER")
    public String getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(String menuOrder) {
        this.menuOrder = menuOrder;
    }

    @Basic
    @Column(name = "IS_LEAF")
    public String getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(String isLeaf) {
        this.isLeaf = isLeaf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseMenuEntity that = (BaseMenuEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(menuUrl, that.menuUrl) && Objects.equals(menuSeq, that.menuSeq) && Objects.equals(menuParentId, that.menuParentId) && Objects.equals(menuName, that.menuName) && Objects.equals(menuIcon, that.menuIcon) && Objects.equals(menuOrder, that.menuOrder) && Objects.equals(isLeaf, that.isLeaf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, menuUrl, menuSeq, menuParentId, menuName, menuIcon, menuOrder, isLeaf);
    }
}
