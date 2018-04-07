package me.eae.webmagic.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-04-06 11:56:51
 */
public class WebmagicUserDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//用户id
	private Long id;
	//
	private String address;
	//
	private String nickName;
	//
	private Integer sex;

	/**
	 * 设置：用户id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：用户id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	/**
	 * 获取：
	 */
	public String getNickName() {
		return nickName;
	}
	/**
	 * 设置：
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：
	 */
	public Integer getSex() {
		return sex;
	}
}
