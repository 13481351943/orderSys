package com.order.common.result;

import com.order.common.enmus.ResponCodeEnmu;

public class Message {

	public String code;
	
	public Object data;
	
	public String message;
	
	public Message() {
		
	}
	
	public Message(String code,Object data,String message) {
		this.code = code;
		this.data = data;
		this.message = message;
	}
	
	public static Message success(Object data) {
		return new Message(ResponCodeEnmu.SUCCESS.getCode(),data,"成功");
	}
	
	public static Message fail(Object data) {
		return new Message(ResponCodeEnmu.FAIL.getCode(),data,"失败");
	}

	public static Message build(String code, Object data, String message) {
		return new Message(code,data,message);
	}
}
