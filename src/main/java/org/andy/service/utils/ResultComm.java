package org.andy.service.utils;

public class ResultComm {

	private String str;
	
	private int count;
	
	private boolean isSuccess;
	
	
	
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public ResultComm(){
	}
	public ResultComm(String str, boolean isSuccess){
		this.str = str;
		this.isSuccess =isSuccess;
	}
	
	public ResultComm(String str){
		this.str = str;
	}
	public ResultComm(int count){
		this.count = count;
	}
	public ResultComm(boolean isSuccess){
		this.isSuccess =isSuccess;
	}
}
