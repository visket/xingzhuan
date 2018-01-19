package com.kedu.xingzhuan.entity;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author：
 * @date  ： 2017年6月5日 下午10:52:13
 * @Desc  ：基础实体类
 */
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = -1440655877648153434L;

	protected Long id; // 主键

	@JsonIgnore
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date createTime; // 创建时间
	@JsonIgnore
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date updateTime; // 修改时间
	@JsonIgnore
	private Long creator; // 创建者
	@JsonIgnore
	private Long updater;// 最后修改者

	public Long getCreator() {
		return creator;
	}

	public void setCreator(Long creator) {
		this.creator = creator;
	}

	public Long getUpdater() {
		return updater;
	}

	public void setUpdater(Long updater) {
		this.updater = updater;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;

		if (obj.getClass().equals(this.getClass()) && (obj instanceof BaseEntity)) {
			BaseEntity entity = (BaseEntity) obj;
			Long eid = entity.getId();
			if (eid == null || id == null)
				return false;
			else
				return eid.longValue() == id.longValue();
		} else
			return false;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);

	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
