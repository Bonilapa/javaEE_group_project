package org.innopolis.javaEE.aureg.forms;

public class LoginForm {
    private String login;
    private String password;
    private String rights;

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public String getRights(){
        return rights;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }

    public LoginForm() {
    }

    public LoginForm(String login, String password) {
        this.login = login;
        this.password = password;
        this.rights = null;
    }
    public LoginForm(String login, String password, String rights) {
        this.login = login;
        this.password = password;
        this.rights = rights;
    }
}
