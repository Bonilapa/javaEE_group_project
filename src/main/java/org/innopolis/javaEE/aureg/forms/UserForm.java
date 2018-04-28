package org.innopolis.javaEE.aureg.forms;

public class UserForm {
    private Integer id;
    private String login;
    private String rights;
    public UserForm(){

    }

    public String getLogin() {
        return login;
    }

    public Integer getId() {
        return id;
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
