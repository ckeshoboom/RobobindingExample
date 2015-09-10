package com.boomtown.ckesho.robobindingexample;

/**
 * Created by ckesho on 9/8/2015.
 */
public class CustomViewData {
    String tvnumber="number";
    String tvemail="email";
    String tvname="name first last";

    public CustomViewData(String name, String email, String number) {
        tvnumber = number;
        tvemail = email;
        tvname = name;
    }

    public String getTvnumber() {
        return tvnumber;
    }

    public void setTvnumber(String tvnumber) {
        this.tvnumber = tvnumber;
    }

    public String getTvemail() {
        return tvemail;
    }

    public void setTvemail(String tvemail) {
        this.tvemail = tvemail;
    }

    public String getTvname() {
        return tvname;
    }

    public void setTvname(String tvname) {
        this.tvname = tvname;
    }
}
