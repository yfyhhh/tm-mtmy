package com.tm.entity;

public class QRCodeUserLogin {
    private String flag;
    private Long beauticianId;
    private String userName;
    private String passWord;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Long getBeauticianId() {
        return beauticianId;
    }

    public void setBeauticianId(Long beauticianId) {
        this.beauticianId = beauticianId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
