package com.newlecture.web.entity;

import java.util.Date;

public class Member {
	private int id;
	private String nicName;
	private String pwd;
	private String name;
	private String gender;
	private String birthday;
	private String phone;
	private String email;
	private Date regdate;
	private String address;

	
	public Member() {
	}


	public Member(int id, String nicName, String pwd, String name, String gender, String birthday, String phone,
			String email, Date regdate, String address) {
		super();
		this.id = id;
		this.nicName = nicName;
		this.pwd = pwd;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
		this.email = email;
		this.regdate = regdate;
		this.address = address;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNicName() {
		return nicName;
	}


	public void setNicName(String nicName) {
		this.nicName = nicName;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getRegdate() {
		return regdate;
	}


	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Member [id=" + id + ", nicName=" + nicName + ", pwd=" + pwd + ", name=" + name + ", gender=" + gender
				+ ", birthday=" + birthday + ", phone=" + phone + ", email=" + email + ", regdate=" + regdate
				+ ", address=" + address + "]";
	}

}

/* ---루틴.---
* 컨트롤 스페이스 : 생성자
* 오른쪽 버트 소스 - 속성넘겨받는 생성자
* 거테세터 생성
* toString 생성
 * 
 * 
사용자입력 닉네임 받아서 검색된 데이터를 보여줌-숙제
 */
