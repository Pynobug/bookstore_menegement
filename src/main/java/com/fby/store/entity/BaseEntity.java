package com.fby.store.entity;

import java.io.Serializable;
import java.util.Date;

/** 作为实体类的基类 */
public class BaseEntity implements Serializable {
    private String creatUser;
    private Date creatTime;
    private String modifiedUser;
    private Date modifiedTime;

    public String getCreatUser() {
        return creatUser;
    }

    public void setCreatUser(String creatUser) {
        this.creatUser = creatUser;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseEntity)) return false;

        BaseEntity that = (BaseEntity) o;

        if (getCreatUser() != null ? !getCreatUser().equals(that.getCreatUser()) : that.getCreatUser() != null)
            return false;
        if (getCreatTime() != null ? !getCreatTime().equals(that.getCreatTime()) : that.getCreatTime() != null)
            return false;
        if (getModifiedUser() != null ? !getModifiedUser().equals(that.getModifiedUser()) : that.getModifiedUser() != null)
            return false;
        return getModifiedTime() != null ? getModifiedTime().equals(that.getModifiedTime()) : that.getModifiedTime() == null;
    }

    @Override
    public int hashCode() {
        int result = getCreatUser() != null ? getCreatUser().hashCode() : 0;
        result = 31 * result + (getCreatTime() != null ? getCreatTime().hashCode() : 0);
        result = 31 * result + (getModifiedUser() != null ? getModifiedUser().hashCode() : 0);
        result = 31 * result + (getModifiedTime() != null ? getModifiedTime().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "creatUser='" + creatUser + '\'' +
                ", creatTime=" + creatTime +
                ", modifiedUser='" + modifiedUser + '\'' +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}
