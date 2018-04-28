package org.innopolis.javaEE.userStatPart.model;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "userstat")
public class Stat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "meanIn")
    private LocalTime meanIn;

    @Column(name = "meanOut")
    private LocalTime meanOut;

    public Stat(){}

    public Stat(Long id, String username, LocalTime meanIn, LocalTime meanOut) {
        this.id = id;
        this.username = username;
        this.meanIn = meanIn;
        this.meanOut = meanOut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalTime getMeanIn() {
        return meanIn;
    }

    public void setMeanIn(LocalTime meanIn) {
        this.meanIn = meanIn;
    }

    public LocalTime getMeanOut() {
        return meanOut;
    }

    public void setMeanOut(LocalTime meanOut) {
        this.meanOut = meanOut;
    }
}
