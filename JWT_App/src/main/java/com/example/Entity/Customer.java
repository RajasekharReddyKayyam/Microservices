package com.example.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
@Document
public class Customer {
	@Id
	private String cid;
	private  String uname;
	private String pwd;
	private  Long phno;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Long getPhno() {
		return phno;
	}
	public void setPhno(Long phno) {
		this.phno = phno;
	}
	
		

}