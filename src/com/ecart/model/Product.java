package com.ecart.model;

public class Product {

	private int productId;
	
	private String productTitle;
	
	private double productPrice;
	
	private String description;
	
	private Brand brand;
	
	private Category category;
	
	private String firstName;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int productId, String productTitle, double productPrice, String description, Brand brand,
			Category category, String firstName) {
		super();
		this.productId = productId;
		this.productTitle = productTitle;
		this.productPrice = productPrice;
		this.description = description;
		this.brand = brand;
		this.category = category;
		this.firstName = firstName;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productTitle=" + productTitle + ", productPrice=" + productPrice
				+ ", description=" + description + ", brand=" + brand + ", category=" + category + ", firstName="
				+ firstName + "]";
	}

	
}
