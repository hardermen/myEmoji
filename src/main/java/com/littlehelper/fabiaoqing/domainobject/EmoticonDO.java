package com.littlehelper.fabiaoqing.domainobject;

import java.io.Serializable;
import java.util.Date;

public class EmoticonDO extends EmoticonDOKey implements Serializable {

    private static final long serialVersionUID = -4168302519256150602L;
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_emoticon.name
     *
     * @mbg.generated Thu May 30 11:31:34 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_emoticon.url
     *
     * @mbg.generated Thu May 30 11:31:34 CST 2019
     */
    private String url;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_emoticon.seq
     *
     * @mbg.generated Thu May 30 11:31:34 CST 2019
     */
    private Integer seq;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_emoticon.create_time
     *
     * @mbg.generated Thu May 30 11:31:34 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_emoticon.update_time
     *
     * @mbg.generated Thu May 30 11:31:34 CST 2019
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_emoticon.name
     *
     * @return the value of t_emoticon.name
     *
     * @mbg.generated Thu May 30 11:31:34 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_emoticon.name
     *
     * @param name the value for t_emoticon.name
     *
     * @mbg.generated Thu May 30 11:31:34 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_emoticon.url
     *
     * @return the value of t_emoticon.url
     *
     * @mbg.generated Thu May 30 11:31:34 CST 2019
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_emoticon.url
     *
     * @param url the value for t_emoticon.url
     *
     * @mbg.generated Thu May 30 11:31:34 CST 2019
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_emoticon.seq
     *
     * @return the value of t_emoticon.seq
     *
     * @mbg.generated Thu May 30 11:31:34 CST 2019
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_emoticon.seq
     *
     * @param seq the value for t_emoticon.seq
     *
     * @mbg.generated Thu May 30 11:31:34 CST 2019
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_emoticon.create_time
     *
     * @return the value of t_emoticon.create_time
     *
     * @mbg.generated Thu May 30 11:31:34 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_emoticon.create_time
     *
     * @param createTime the value for t_emoticon.create_time
     *
     * @mbg.generated Thu May 30 11:31:34 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_emoticon.update_time
     *
     * @return the value of t_emoticon.update_time
     *
     * @mbg.generated Thu May 30 11:31:34 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_emoticon.update_time
     *
     * @param updateTime the value for t_emoticon.update_time
     *
     * @mbg.generated Thu May 30 11:31:34 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}