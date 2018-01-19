package com.kedu.xingzhuan.entity.xs;

import java.io.Serializable;
import java.util.Date;

/**
 * 线索批次表
 * @author around
 * @date 2018-1-16
 */
public class XspcEntity implements Serializable {
	
	private static final long serialVersionUID = 8377187065003413929L;
	
	/** id */
	private String id;
	
	/** 线索名称 */
    private String xsmc;
	
	/** 线索类型 */
    private String xslx;
	
	/** 线索事由 */
    private String xssy;
    
    /** 线索内容 */
    private String xsnr;
	
	/** 工作要求 */
    private String gzyq;
	
	/** 线索内容 */
    private Date cjsj;
	
	/** 发布时间 */
    private Date fbsj;
	
	/** 回报时间 */
    private Date hbsj;
	
	/** 附件 */
    private String fj;
	
	/** 优先级 */
    private Integer yxj;
	
	/** 是否删除 */
    private Integer sfsc;
	
	/** 创建人 */
    private String cjr;
	
	/** 修改人 */
    private String xgr;
	
	/** 修改时间 */
    private Date xgsj;
	
	
	/**  */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getXsmc() {
        return xsmc;
    }

    public void setXsmc(String xsmc) {
        this.xsmc = xsmc == null ? null : xsmc.trim();
    }

    public String getXslx() {
        return xslx;
    }

    public void setXslx(String xslx) {
        this.xslx = xslx == null ? null : xslx.trim();
    }

    public String getXssy() {
        return xssy;
    }

    public void setXssy(String xssy) {
        this.xssy = xssy == null ? null : xssy.trim();
    }

    public String getGzyq() {
        return gzyq;
    }

    public void setGzyq(String gzyq) {
        this.gzyq = gzyq == null ? null : gzyq.trim();
    }

    public Date getCjsj() {
        return cjsj;
    }

    public void setCjsj(Date cjsj) {
        this.cjsj = cjsj;
    }

    public Date getFbsj() {
        return fbsj;
    }

    public void setFbsj(Date fbsj) {
        this.fbsj = fbsj;
    }

    public Date getHbsj() {
        return hbsj;
    }

    public void setHbsj(Date hbsj) {
        this.hbsj = hbsj;
    }

    public String getFj() {
        return fj;
    }

    public void setFj(String fj) {
        this.fj = fj == null ? null : fj.trim();
    }

    public Integer getYxj() {
        return yxj;
    }

    public void setYxj(Integer yxj) {
        this.yxj = yxj;
    }

    public Integer getSfsc() {
        return sfsc;
    }

    public void setSfsc(Integer sfsc) {
        this.sfsc = sfsc;
    }

    public String getCjr() {
        return cjr;
    }

    public void setCjr(String cjr) {
        this.cjr = cjr == null ? null : cjr.trim();
    }

    public String getXgr() {
        return xgr;
    }

    public void setXgr(String xgr) {
        this.xgr = xgr == null ? null : xgr.trim();
    }

    public Date getXgsj() {
        return xgsj;
    }

    public void setXgsj(Date xgsj) {
        this.xgsj = xgsj;
    }

	public String getXsnr() {
		return xsnr;
	}

	public void setXsnr(String xsnr) {
		this.xsnr = xsnr;
	}
    
    

}