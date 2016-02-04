package com.lj.beans;

public class TbUser {

	private int uid;// int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
	private String username;// varchar NOT NULL COMMENT '用户名称',
	private String passwd;// varchar NOT NULL COMMENT '密码',
	private String email;// varchar COMMENT '箱邮地址',
	private String bak;// varchar COMMENT '注备',
	private long createtime;// varchar NOT NULL COMMENT '创建时间',

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBak() {
		return bak;
	}

	public void setBak(String bak) {
		this.bak = bak;
	}

	public long getCreatetime() {
		return createtime;
	}

	public void setCreatetime(long createtime) {
		this.createtime = createtime;
	}

	@Override
	public String toString() {
		return "TbUser [uid=" + uid + ", username=" + username + ", passwd=" + passwd + ", email=" + email + ", bak=" + bak + ", createtime=" + createtime + "]";
	}
}
