package com.order.vo;

import com.order.entity.OrderSku;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class CookingOrder implements Serializable {
    
    
    
    
	private List<OrderSku> cookingList;
	private List<OrderSku> barbecueList;
	public List<OrderSku> getCookingList() {
		return cookingList;
	}
	public void setCookingList(List<OrderSku> cookingList) {
		this.cookingList = cookingList;
	}
	public List<OrderSku> getBarbecueList() {
		return barbecueList;
	}
	public void setBarbecueList(List<OrderSku> barbecueList) {
		this.barbecueList = barbecueList;
	}
	
}
