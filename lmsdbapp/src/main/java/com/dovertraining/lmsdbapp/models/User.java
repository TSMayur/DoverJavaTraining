package com.dovertraining.lmsdbapp.models;

public class User {
    private final int userId;
    private final String firstName;
    private final String lastName;
    private final String roleId;
    private final String companyId;

    public User(int userId, String firstName, String lastName, String roleId, String companyId) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roleId = roleId;
        this.companyId = companyId;
    }

    public int getUserId() { return userId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getRoleId() { return roleId; }
    public String getCompanyId() { return companyId; }
}
