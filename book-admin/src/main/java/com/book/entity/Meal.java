package com.book.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * 菜单表(Menu)表实体类
 *
 * @author jojo思密达
 * @since 2025-09-18 15:33:25
 */
@SuppressWarnings("serial")
public class Meal extends Model<Meal> {
  //主键
    private Integer id;
  //菜肴名字
    private String dishesName;
  //菜肴种类
    private String dishesKind;
  //菜肴使用者
    private String dishesUser;
  //创建时间
    private String createTime;
  //创建人
    private String creater;
  //更新时间
    private String updateTime;
  //更新者
    private String updater;
  //是否删除
    private Integer isDelete;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDishesName() {
        return dishesName;
    }

    public void setDishesName(String dishesName) {
        this.dishesName = dishesName;
    }

    public String getDishesKind() {
        return dishesKind;
    }

    public void setDishesKind(String dishesKind) {
        this.dishesKind = dishesKind;
    }

    public String getDishesUser() {
        return dishesUser;
    }

    public void setDishesUser(String dishesUser) {
        this.dishesUser = dishesUser;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

}

