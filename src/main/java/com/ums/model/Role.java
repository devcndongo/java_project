package com.ums.model;

public class Role {
    private String name;
    private RoleEnum roleEnum;

    public Role() {
    }

    public Role(String name, RoleEnum roleEnum) {
        this.name = name;
        this.roleEnum = roleEnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoleEnum getRoleEnum() {
        return roleEnum;
    }

    public void setRoleEnum(RoleEnum roleEnum) {
        this.roleEnum = roleEnum;
    }

    @Override
    public String toString() {
        return name;
    }
}
