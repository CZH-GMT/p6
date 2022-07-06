package com.example.ceshitiku4;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

import java.io.Serializable;

@Entity
public class Bean implements Serializable {
    private static final long serialVersionUID = 7494163050490129047L;
    @Id
    private Long id;
    private String name;
    private int phone;
    private String sex;
    @Generated(hash = 618217217)
    public Bean(Long id, String name, int phone, String sex) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.sex = sex;
    }

    public Bean( String name, int phone, String sex) {
        this.name = name;
        this.phone = phone;
        this.sex = sex;
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
    public int getPhone() {
        return this.phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

}
