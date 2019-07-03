package com.iu.member;

import com.iu.memberfile.MemberfileVO;

public class MemberVO {
	private String id;
	private String pw;
	private String name;
	private String email;
	private int grade;
	private MemberfileVO memberfileVO;
	
	public MemberfileVO getMemberfileVO() {
		return memberfileVO;
	}
	public void setMemberfileVO(MemberfileVO memberfileVO) {
		this.memberfileVO = memberfileVO;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
}