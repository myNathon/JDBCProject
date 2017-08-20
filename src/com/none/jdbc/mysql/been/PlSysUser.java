package com.none.jdbc.mysql.been;

/**
 * 系统用户值对象
 * @author Nathon
 *
 */
public class PlSysUser {
	private String acct;	//用户账号
	private String passw;	//用户密码
	private String type;	//用户类型
	private String name;	//用户姓名
	private String phone;	//手机号码
	
	public String getAcct() {
		return acct;
	}
	public void setAcct(String acct) {
		this.acct = acct;
	}
	public String getPassw() {
		return passw;
	}
	public void setPassw(String passw) {
		this.passw = passw;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
