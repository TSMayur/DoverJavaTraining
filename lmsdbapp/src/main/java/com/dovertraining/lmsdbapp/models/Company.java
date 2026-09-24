package com.dovertraining.lmsdbapp.models;

public class Company {
    private final String companyId;
    private final String companyName;
    private final String description;

    public Company(String companyId, String companyName, String description) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.description = description;
    }

    public String getCompanyId() { return companyId; }
    public String getCompanyName() { return companyName; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return "Company{id='" + companyId + "', name='" + companyName
                + "', description='" + description + "'}";
    }
}
