package com.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Permission implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.iconCls
     *
     * @mbggenerated
     */
    private String iconcls;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.path
     *
     * @mbggenerated
     */
    private String path;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.url
     *
     * @mbggenerated
     */
    private String url;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.fatherId
     *
     * @mbggenerated
     */
    private String fatherid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.create_time
     *
     * @mbggenerated
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.update_time
     *
     * @mbggenerated
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.creater
     *
     * @mbggenerated
     */
    private String creater;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.updater
     *
     * @mbggenerated
     */
    private String updater;

    private List<Permission> childMenus;

    public List<Permission> getChildMenus() {
        return childMenus;
    }

    public void setChildMenus(List<Permission> childMenus) {
        this.childMenus = childMenus;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table permission
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.id
     *
     * @return the value of permission.id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.id
     *
     * @param id the value for permission.id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.name
     *
     * @return the value of permission.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.name
     *
     * @param name the value for permission.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.iconCls
     *
     * @return the value of permission.iconCls
     *
     * @mbggenerated
     */
    public String getIconcls() {
        return iconcls;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.iconCls
     *
     * @param iconcls the value for permission.iconCls
     *
     * @mbggenerated
     */
    public void setIconcls(String iconcls) {
        this.iconcls = iconcls == null ? null : iconcls.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.path
     *
     * @return the value of permission.path
     *
     * @mbggenerated
     */
    public String getPath() {
        return path;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.path
     *
     * @param path the value for permission.path
     *
     * @mbggenerated
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.url
     *
     * @return the value of permission.url
     *
     * @mbggenerated
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.url
     *
     * @param url the value for permission.url
     *
     * @mbggenerated
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.fatherId
     *
     * @return the value of permission.fatherId
     *
     * @mbggenerated
     */
    public String getFatherid() {
        return fatherid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.fatherId
     *
     * @param fatherid the value for permission.fatherId
     *
     * @mbggenerated
     */
    public void setFatherid(String fatherid) {
        this.fatherid = fatherid == null ? null : fatherid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.create_time
     *
     * @return the value of permission.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.create_time
     *
     * @param createTime the value for permission.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.update_time
     *
     * @return the value of permission.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.update_time
     *
     * @param updateTime the value for permission.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.creater
     *
     * @return the value of permission.creater
     *
     * @mbggenerated
     */
    public String getCreater() {
        return creater;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.creater
     *
     * @param creater the value for permission.creater
     *
     * @mbggenerated
     */
    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.updater
     *
     * @return the value of permission.updater
     *
     * @mbggenerated
     */
    public String getUpdater() {
        return updater;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.updater
     *
     * @param updater the value for permission.updater
     *
     * @mbggenerated
     */
    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
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
        sb.append(", name=").append(name);
        sb.append(", iconcls=").append(iconcls);
        sb.append(", path=").append(path);
        sb.append(", url=").append(url);
        sb.append(", fatherid=").append(fatherid);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", creater=").append(creater);
        sb.append(", updater=").append(updater);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
