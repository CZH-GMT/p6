package com.example.qizhongtiku4;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

import java.io.Serializable;

@Entity
public class Bean implements Serializable {
    private static final long serialVersionUID = 325268691205223215L;
    @Id
    private Long id;
    private String name;

    private String password;
    private int age;
    private String phone;
    @Generated(hash = 735487110)
    public Bean(Long id, String name, String password, int age, String phone) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.phone = phone;
    }
    @Generated(hash = 80546095)
    public Bean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

}
