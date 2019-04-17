package com.dancer.crud.entity;

import java.util.Date;

import org.springframework.stereotype.Repository;

@Repository
public class Administrator {
    private Integer tId;

    private String tName;

    private String tUuid;

    private String tPassword;

    private Date tCreatetime;

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName == null ? null : tName.trim();
    }

    public String gettUuid() {
        return tUuid;
    }

    public void settUuid(String tUuid) {
        this.tUuid = tUuid;
    }

    public String gettPassword() {
        return tPassword;
    }

    public void settPassword(String tPassword) {
        this.tPassword = tPassword == null ? null : tPassword.trim();
    }

    public Date gettCreatetime() {
        return tCreatetime;
    }

    public void settCreatetime(Date tCreatetime) {
        this.tCreatetime = tCreatetime;
    }
}