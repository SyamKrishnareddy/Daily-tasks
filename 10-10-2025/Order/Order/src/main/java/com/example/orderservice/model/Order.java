package com.example.orderservice.model;


public class Order {
    private String orderId;
    private String productId;
    private String productName;
    private double productPrice;
    private String status;


    public Order() {}

    public Order(String orderId, String productId) {
        this.orderId = orderId;
        this.productId = productId;
        this.status = "PENDING";
    }

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", productId=" + productId + ", productName=" + productName
				+ ", productPrice=" + productPrice + ", status=" + status + "]";
	}

    
}
