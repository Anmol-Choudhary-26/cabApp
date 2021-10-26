package com.example.rentacab.modal;

public class user {
    String profile_pic,userName,mail,password,userId,lastMsg;

    public user(String profile_pic, String userName, String mail, String password, String userId, String lastMsg) {
        this.profile_pic = profile_pic;
        this.userName = userName;
        this.mail = mail;
        this.password = password;
        this.userId = userId;
        this.lastMsg = lastMsg;
    }
    public user(){}
    // register_constructor
    public user( String userName, String mail, String password) {

        this.userName = userName;
        this.mail = mail;
        this.password = password;


    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public String getUserName() {
        return userName;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public String getUserId() {
        return userId;
    }

    public String getLastMsg() {
        return lastMsg;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setLastMsg(String lastMsg) {
        this.lastMsg = lastMsg;
    }
}
