package com.kh.java.model;

import java.sql.Date;

//거래 정보
public class TransactionVO {
	private int totalOrders; // --총 주문 수
	private double totalSpend; // --총 지출 금액
	private Date lastPurchaseDate; // --마지막 구매 날짜
	private String preferredPaymentMethod; // --선호 결제 방법 (예: 카드, 현금, 포인트)
	private String favoriteProducts; // --선호 상품 목록

	public TransactionVO() {
	}

	public TransactionVO(int totalOrders, double totalSpend, Date lastPurchaseDate, String preferredPaymentMethod,
			String favoriteProducts) {
		super();
		this.totalOrders = totalOrders;
		this.totalSpend = totalSpend;
		this.lastPurchaseDate = lastPurchaseDate;
		this.preferredPaymentMethod = preferredPaymentMethod;
		this.favoriteProducts = favoriteProducts;
	}

	public int getTotalOrders() {
		return totalOrders;
	}

	public void setTotalOrders(int totalOrders) {
		this.totalOrders = totalOrders;
	}

	public double getTotalSpend() {
		return totalSpend;
	}

	public void setTotalSpend(double totalSpend) {
		this.totalSpend = totalSpend;
	}

	public Date getLastPurchaseDate() {
		return lastPurchaseDate;
	}

	public void setLastPurchaseDate(Date lastPurchaseDate) {
		this.lastPurchaseDate = lastPurchaseDate;
	}

	public String getPreferredPaymentMethod() {
		return preferredPaymentMethod;
	}

	public void setPreferredPaymentMethod(String preferredPaymentMethod) {
		this.preferredPaymentMethod = preferredPaymentMethod;
	}

	public String getFavoriteProducts() {
		return favoriteProducts;
	}

	public void setFavoriteProducts(String favoriteProducts) {
		this.favoriteProducts = favoriteProducts;
	}

	@Override
	public String toString() {
		return "[totalOrders=" + totalOrders + ", totalSpend=" + totalSpend + ", lastPurchaseDate=" + lastPurchaseDate
				+ ", preferredPaymentMethod=" + preferredPaymentMethod + ", favoriteProducts=" + favoriteProducts + "]";
	}
}