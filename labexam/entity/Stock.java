package com.rest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer stockId; 
	
	@Column(length = 50)
	private String companyName;
	
	@Column(length = 50)
	private Integer currentPrice;
	
	@Column(length = 50)
	private Integer quantity; 
	
    private String tradeDate;
    
	public Stock() {


	}

	public Stock(Integer stockId, String companyName, Integer currentPrice, Integer quantity, String tradeDate) {
		super();
		this.stockId = stockId;
		this.companyName = companyName;
		this.currentPrice = currentPrice;
		this.quantity = quantity;
		this.tradeDate = tradeDate;
	}

	public Integer getStockId() {
		return stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(Integer currentPrice) {
		this.currentPrice = currentPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}

	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", companyName=" + companyName + ", currentPrice=" + currentPrice
				+ ", quantity=" + quantity + ", tradeDate=" + tradeDate + "]";
	}
	

}
