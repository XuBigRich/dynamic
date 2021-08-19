package cn.piao888.dynamic.domain;

import com.alibaba.druid.sql.visitor.functions.Char;


public class SysRole {
    private Integer id;

    private String roleName;

    private String roleKey;

    private Integer roleSort;

    private Char status;


    public Integer getRoleId() {
        return id;
    }

    public void setRoleId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }

    public Integer getRoleSort() {
        return roleSort;
    }

    public void setRoleSort(Integer roleSort) {
        this.roleSort = roleSort;
    }

    public Char getStatus() {
        return status;
    }

    public void setStatus(Char status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "roleId=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleKey='" + roleKey + '\'' +
                ", roleSort=" + roleSort +
                ", status=" + status +
                '}';
    }
}
