package com.lyg.entitys;
/**
 * 实体类
 * @author
 *
 */
public class Person {
	
	private Integer id ;
	private String name;
	private String age;
	private String sex;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	@Override
	public String toString() {
		return super.toString();
	}

}
