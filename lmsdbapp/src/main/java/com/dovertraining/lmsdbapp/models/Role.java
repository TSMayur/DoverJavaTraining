package com.dovertraining.lmsdbapp.models;

public class Role {
    private final String roleId;
    private final String roleName;

    public Role(String roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public String getRoleId() { return roleId; }
    public String getRoleName() { return roleName; }
}
