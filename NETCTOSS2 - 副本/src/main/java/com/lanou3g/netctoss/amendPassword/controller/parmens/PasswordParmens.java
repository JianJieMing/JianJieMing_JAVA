package com.lanou3g.netctoss.amendPassword.controller.parmens;

public class PasswordParmens {

    private String oldPassword;
    private String newPassword;

    @Override
    public String toString() {
        return "PasswordParmens{" +
                "oldPassword='" + oldPassword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
