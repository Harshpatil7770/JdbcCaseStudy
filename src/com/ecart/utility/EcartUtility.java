package com.ecart.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ecart.dao.ProductDaoImpl;
import com.ecart.model.Brand;
import com.ecart.model.Category;
import com.ecart.model.Product;

public class EcartUtility {

	public void addCategory() {
		List<String> list=new ArrayList<String>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter category Name");
		String name=sc.next();
		
		Category category=new Category();
	
		category.setCategoryTitle(name);
		
		ProductDaoImpl p1=new ProductDaoImpl();
		p1.addNewCategory(category);
	}
	
	public void addNewBrand() {
		List<String> list=new ArrayList<String>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter New Brand Name");
		String name=sc.next();
		
		Brand brand=new Brand();
		brand.setBrandTitle(name);
		
		ProductDaoImpl p1=new ProductDaoImpl();
		p1.addNewBrand(brand);
}
	
	public void addNewProduct() {
		List<String> list=new ArrayList<String>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter New Product");
		String product=sc.next();
		System.out.println("Enter Product Price");
		double price=sc.nextDouble();
		System.out.println(" Enter Product description");
		String str=sc.next();
		System.out.println("Enter brand Id");
		int brandId=sc.nextInt();
		System.out.println("Enter category Id");
		int categoryId=sc.nextInt();
		
		Product product1=new Product();
		Brand brand1=new Brand();
		Category category1=new Category();
		product1.setProductTitle(product);
		product1.setProductPrice(price);
		product1.setDescription(str);
		product1.setBrand(brand1);
		product1.setCategory(category1);
		
		ProductDaoImpl p1=new ProductDaoImpl();
		p1.addNewProduct(product1);
		
	}
	
	public void allOrderPrdouct() {
		List<String> list=new ArrayList<String>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter user first name to show orders");
		String name=sc.next();
		
		Product product1=new Product();
		product1.setFirstName(name);
		System.out.println(product1);
		
		ProductDaoImpl p1=new ProductDaoImpl();
		p1.allOrderOfUser(product1);
	}
	
	public void clearAllCartUtility() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your userId to clear cart");
		String userId=sc.next();
		ProductDaoImpl p2=new ProductDaoImpl();
		 p2.clearAllCart(userId);
		
	}
}
