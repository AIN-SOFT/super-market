package com.soft1841.sm.entity;

public class GuanLi {
    private Long id ;
    private String name;
    private String xinbie;
    private String picture;
    private String xueli;
    private String mobile;

    public GuanLi(Long id, String name, String xinbie, String picture, String xueli, String mobile) {
        this.id = id;
        this.name = name;
        this.xinbie = xinbie;
        this.picture = picture;
        this.xueli = xueli;
        this.mobile = mobile;
    }
    public GuanLi(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getXinbie() {
        return xinbie;
    }

    public void setXinbie(String xinbie) {
        this.xinbie = xinbie;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getXueli() {
        return xueli;
    }

    public void setXueli(String xueli) {
        this.xueli = xueli;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "GuanLi{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", xinbie='" + xinbie + '\'' +
                ", picture='" + picture + '\'' +
                ", xueli='" + xueli + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
