package org.innopolis.javaEE.aureg.forms;

public class EditRights {
    private Integer adminRights;
    private Integer userRights;
    private Integer deleteUser;

    public EditRights() {
    }

    public void setAdminRights(Integer adminRights) {
        this.adminRights = adminRights;
    }

    public void setUserRights(Integer useRights) {
        this.userRights = useRights;
    }

    public void setDeleteUser(Integer deleteUser) {
        this.deleteUser = deleteUser;
    }

    public Integer getAdminRights() {
        return adminRights;
    }

    public Integer getUserRights() {
        return userRights;
    }

    public Integer getDeleteUser() {
        return deleteUser;
    }
}
