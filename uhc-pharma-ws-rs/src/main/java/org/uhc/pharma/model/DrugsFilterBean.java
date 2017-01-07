package org.uhc.pharma.model;

import javax.ws.rs.CookieParam;
import javax.ws.rs.HeaderParam;

public class DrugsFilterBean {
	
	
	private @HeaderParam("user") String user;
	private  @HeaderParam("customVal") String customVal;
	private  @CookieParam("val") String val;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getCustomVal() {
		return customVal;
	}
	public void setCustomVal(String customVal) {
		this.customVal = customVal;
	}
	public String getVal() {
		return val;
	}
	public void setVal(String val) {
		this.val = val;
	}
	
	
}
