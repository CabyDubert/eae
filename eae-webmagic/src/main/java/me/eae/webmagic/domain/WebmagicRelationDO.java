package me.eae.webmagic.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-04-06 11:56:49
 */
public class WebmagicRelationDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//
	private Long userId;
	//
	private Long relationId;
	//
	private Integer relationType;

	/**
	 * 设置：
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：
	 */
	public void setRelationId(Long relationId) {
		this.relationId = relationId;
	}
	/**
	 * 获取：
	 */
	public Long getRelationId() {
		return relationId;
	}
	/**
	 * 设置：
	 */
	public void setRelationType(Integer relationType) {
		this.relationType = relationType;
	}
	/**
	 * 获取：
	 */
	public Integer getRelationType() {
		return relationType;
	}
}
