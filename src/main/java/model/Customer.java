package model;

public class Customer {
    private int customerId;
    private String initials;
    private String prefix;
    private String surName;
    private String mobilePhone;

    public Customer(int customerId, String initials, String prefix, String surName, String mobilePhone) {
        this.customerId = customerId;
        this.initials = initials;
        this.prefix = prefix;
        this.surName = surName;
        this.mobilePhone = mobilePhone;
    }

    public Customer(String initials, String prefix, String surName, String mobilePhone) {
        this.initials = initials;
        this.prefix = prefix;
        this.surName = surName;
        this.mobilePhone = mobilePhone;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder("");
        resultString.append(customerId + " ");
        resultString.append(initials + " ");
        if (prefix != null) {
            resultString.append(prefix + " ");
        }
        resultString.append(surName);
        return resultString.toString();
    }
}
