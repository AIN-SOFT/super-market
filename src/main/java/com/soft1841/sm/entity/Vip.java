package com.soft1841.sm.entity;

/**
 * Vip 实体类
 * @auther 侯粤嘉
 * 2918年12月24日
 */
public class Vip {
    private Long id;
    private String name;
    private String year;
    private String picture;
    private String jifen;
    private String mobile;
    private String address;

    public Vip(Long id, String name, String year, String picture, String jifen, String mobile, String address) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.picture = picture;
        this.jifen = jifen;
        this.mobile = mobile;
        this.address = address;
    }

    public Vip() {
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getJifen() {
        return jifen;
    }

    public void setJifen(String jifen) {
        this.jifen = jifen;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Vip{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", picture='" + picture + '\'' +
                ", jifen='" + jifen + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
