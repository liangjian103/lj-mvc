package com.lj.beans;


public class Result {

	private int state;// 0成功，1失败
	private String msg;// 描述
	private Object obj;//业务对象
	
	
	public Result() {
		
	}
	
	public Result(int state, String msg) {
		this.state = state;
		this.msg = msg;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	@Override
	public String toString() {
		return "Result [state=" + state + ", msg=" + msg + "]";
	}
}
