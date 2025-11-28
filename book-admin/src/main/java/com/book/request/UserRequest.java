package com.book.request;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户表，存储用户基本信息(User)表实体类
 *
 * @author jojo思密达
 * @since 2025-11-19 18:00:48
 */
@SuppressWarnings("serial")
public class UserRequest  {
    //主键
    private Long id;
    //用户名
    private String userName;
    //性别
    private String sex;
    //手机号码
    private String phone;
    //邮箱
    private String email;
    //生日
    private String birthday;
    //昵称
    private String nickName;
    //备注
    private String memo;
    /**
     * 角色
     */
    private List<String> roles;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}

