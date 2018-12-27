package com.soft1841.sm.entity;

/**
 * 前台实体类
 * @auther 徐鹏
 * 2018年12月25日
 */
public class QianTai {
    private Long id;
    private String number ;
    private String password;
    private String name;

    public QianTai(Long id, String number, String password, String name) {
        this.id = id;
        this.number = number;
        this.password = password;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "QianTai{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
