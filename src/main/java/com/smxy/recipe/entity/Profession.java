/**   
 * Copyright © 2018 eSunny Info. Developer Stu. All rights reserved.
 * 
 * @Package: com.smxy.recipe.domain 
 * @author: 雏实。   
 * Build File @date: 2018年7月4日 下午1:29:34 
 */
package com.smxy.recipe.entity;

/**
 * @author zpx
 *
 */
public class Profession {
	private Integer fId;
	private String fName;
	public Profession() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profession(Integer fId, String fName) {
		this.fId = fId;
		this.fName = fName;
	}

	public Integer getfId() {
		return fId;
	}

	public void setfId(Integer fId) {
		this.fId = fId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	@Override
	public String toString() {
		return "Profession{" +
				"fId=" + fId +
				", fName='" + fName + '\'' +
				'}';
	}
}
