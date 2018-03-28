package me.eae.upms.model;

import java.io.Serializable;


/**
 * 资源类型和角色对应表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-03-15 11:07:13
 */
public class RoleResourceTypeDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//ID
	private Long id;
	//角色id
	private Long roleId;

	public Long getResourceTypeId() {
		return resourceTypeId;
	}

	public void setResourceTypeId(Long resourceTypeId) {
		this.resourceTypeId = resourceTypeId;
	}

	//资源类型
	private Long resourceTypeId;

	/**
	 * 设置：ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：角色id
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	/**
	 * 获取：角色id
	 */
	public Long getRoleId() {
		return roleId;
	}

}
