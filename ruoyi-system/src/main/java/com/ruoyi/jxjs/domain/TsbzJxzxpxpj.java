package com.ruoyi.jxjs.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 见习之星教师培训评价对象 tsbz_jxzxpxpj
 * 
 * @author ruoyi
 * @date 2020-11-09
 */
public class TsbzJxzxpxpj extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 基地校ID */
    @Excel(name = "基地校ID")
    private String jdxid;

    /** 教师id */
    @Excel(name = "教师id")
    private Long jsid;

    /** 培训表现 */
    @Excel(name = "培训表现")
    private String pxbx;

    /** 培训年份 */
    @JsonFormat(pattern = "yyyy")
    @Excel(name = "培训年份", width = 30, dateFormat = "yyyy")
    private Date pxnf;

    /** 备用字段 */
    @Excel(name = "备用字段")
    private String pxBeiyong;

    /** 创建人 */
    @Excel(name = "创建人")
    private Long createUserid;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "访问时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setJdxid(String jdxid) 
    {
        this.jdxid = jdxid;
    }

    public String getJdxid() 
    {
        return jdxid;
    }
    public void setJsid(Long jsid) 
    {
        this.jsid = jsid;
    }

    public Long getJsid() 
    {
        return jsid;
    }
    public void setPxbx(String pxbx) 
    {
        this.pxbx = pxbx;
    }

    public String getPxbx() 
    {
        return pxbx;
    }
    public void setPxnf(Date pxnf) 
    {
        this.pxnf = pxnf;
    }

    public Date getPxnf() 
    {
        return pxnf;
    }
    public void setPxBeiyong(String pxBeiyong) 
    {
        this.pxBeiyong = pxBeiyong;
    }

    public String getPxBeiyong() 
    {
        return pxBeiyong;
    }
    public void setCreateUserid(Long createUserid) 
    {
        this.createUserid = createUserid;
    }

    public Long getCreateUserid() 
    {
        return createUserid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("jdxid", getJdxid())
            .append("jsid", getJsid())
            .append("pxbx", getPxbx())
            .append("pxnf", getPxnf())
            .append("pxBeiyong", getPxBeiyong())
            .append("createUserid", getCreateUserid())
            .append("createTime", getCreateTime())
            .toString();
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
