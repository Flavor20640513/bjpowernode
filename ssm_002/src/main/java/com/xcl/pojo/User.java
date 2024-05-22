package com.xcl.pojo;

public class User {
    private String userId;
    private String cardType;
    private String cardName;
    private String cardNo;
    private  String userSex;
    private  String userPass;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", cardType='" + cardType + '\'' +
                ", cardName='" + cardName + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userPass='" + userPass + '\'' +
                '}';
    }

    public User(String cardType, String cardName, String cardNo, String userSex, String userPass) {
        this.cardType = cardType;
        this.cardName = cardName;
        this.cardNo = cardNo;
        this.userSex = userSex;
        this.userPass = userPass;
    }

    public User() {
    }

    public User(String userId, String cardType, String cardName, String cardNo, String userSex, String userPass) {
        this.userId = userId;
        this.cardType = cardType;
        this.cardName = cardName;
        this.cardNo = cardNo;
        this.userSex = userSex;
        this.userPass = userPass;
    }
}
