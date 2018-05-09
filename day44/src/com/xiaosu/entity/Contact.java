package com.xiaosu.entity;

public class Contact {
	private String id;
	private String name;
	private String gender;
	private int age;
	private String jiguan;
	private String qq;
	private String email;
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contact(String id, String name, String gender, int age,
			String jiguan, String qq, String email) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.jiguan = jiguan;
		this.qq = qq;
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getJiguan() {
		return jiguan;
	}
	public void setJiguan(String jiguan) {
		this.jiguan = jiguan;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", gender=" + gender
				+ ", age=" + age + ", jiguan=" + jiguan + ", qq=" + qq
				+ ", email=" + email + "]";
	}
	
}
