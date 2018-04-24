package org.innopolis.javaEE.aureg.forms;

public class LoginFrom {
    private String login;
    private String password;

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public LoginFrom(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
