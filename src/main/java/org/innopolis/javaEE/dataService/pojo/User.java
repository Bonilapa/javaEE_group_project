package org.innopolis.javaEE.dataService.pojo;

public class User {
    int id;
    String login;
    String password;
    String rights;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getRights() {
        return rights;
    }

    public User(int id, String login, String password, String rights) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.rights = rights;
    }

    public User(String login, String password, String rights) {
        this.login = login;
        this.password = password;
        this.rights = rights;
    }
    public User(int id, String login, String rights) {
        this.login = login;
        this.password = null;
        this.rights = rights;
    }
}
