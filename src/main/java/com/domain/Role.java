package com.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Role implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.role_name
     *
     * @mbggenerated
     */
    private String roleName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.describtion
     *
     * @mbggenerated
     */
    private String describtion;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.create_time
     *
     * @mbggenerated
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.update_time
     *
     * @mbggenerated
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table role
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.id
     *
     * @return the value of role.id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.id
     *
     * @param id the value for role.id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.role_name
     *
     * @return the value of role.role_name
     *
     * @mbggenerated
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.role_name
     *
     * @param roleName the value for role.role_name
     *
     * @mbggenerated
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.describtion
     *
     * @return the value of role.describtion
     *
     * @mbggenerated
     */
    public String getDescribtion() {
        return describtion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.describtion
     *
     * @param describtion the value for role.describtion
     *
     * @mbggenerated
     */
    public void setDescribtion(String describtion) {
        this.describtion = describtion == null ? null : describtion.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.create_time
     *
     * @return the value of role.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.create_time
     *
     * @param createTime the value for role.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.update_time
     *
     * @return the value of role.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.update_time
     *
     * @param updateTime the value for role.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roleName=").append(roleName);
        sb.append(", describtion=").append(describtion);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
