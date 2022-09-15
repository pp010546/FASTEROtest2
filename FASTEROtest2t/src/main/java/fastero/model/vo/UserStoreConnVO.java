package com.fastero.model.vo;

import java.sql.Date;

public class UserStoreConnVO {
//	user_id, store_id, status, statusUpdateTime
	private Integer userId;
	private Integer storeId;
	private Integer status;
	private String statusUpdateTime;
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getStatusUpdateTime() {
		return statusUpdateTime;
	}
	public void setStatusUpdateTime(String statusUpdateTime) {
		this.statusUpdateTime = statusUpdateTime;
	}
	

	
}
