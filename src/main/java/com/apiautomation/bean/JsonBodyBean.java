package com.apiautomation.bean;

public class JsonBodyBean {
	

	private String name;
	private String job;
	
	
	public JsonBodyBean(String name, String job) {
		this.name = name;
		this.job = job;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}

}
