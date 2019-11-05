package com.order.vo;

import java.io.Serializable;
import java.util.List;



public class CookingOrderMain implements Serializable{
	private List<OrderVO> cookingList;

	public List<OrderVO> getCookingList() {
		return cookingList;
	}

	public void setCookingList(List<OrderVO> cookingList) {
		this.cookingList = cookingList;
	}
	
	
}
