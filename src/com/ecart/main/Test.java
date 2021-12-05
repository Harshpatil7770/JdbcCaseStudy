package com.ecart.main;

import java.util.Scanner;

import com.ecart.dao.ProductDaoImpl;
import com.ecart.utility.EcartUtility;

public class Test {

	public void showMain() {
		System.out.println("============================= Welocme To Ecart ==============================");
		System.out.println(" 1) list of All Product Currently avaliable on Ecart  ");
		System.out.println(" 2) list of All Brands");
		System.out.println(" 3) list of All Categories");
		System.out.println(" 4) list of All products having brand name  Samsung");
		System.out.println(" 5) list of All Electronics Products");
		System.out.println(" 6) Add New Category");
		System.out.println(" 7) Add New Brand ");
		System.out.println(" 8) Add New Product");
		System.out.println(" 9) list of All order of User");
		System.out.println(" 10) clear All Items cart");
		Scanner sc=new Scanner(System.in);
		System.out.println(" Enter your choice ::");
		String ch=sc.nextLine();
		
		ProductDaoImpl prod=new ProductDaoImpl ();
		EcartUtility e1=new EcartUtility();
		
		switch(ch) {
		case "1":
			System.out.println("============List Of All Product=============");
			prod.fetchAllProducts().forEach(System.out::println);
			break;
			
		case "2":
			System.out.println("============= List of All Brands=============");
			prod.listOfAllBrand().forEach(System.out::println);
			break;
			
		case "3":
			System.out.println("============== List of All Category===========");
			prod.listOfAllCategories().forEach(System.out::println);
			break;
		
		case "4":
			System.out.println("============ List of All Samsung Product===========");
			prod.listOfALLProductHavingNameSamsung().forEach(System.out::println);
			break;
			
		case "5":
			System.out.println("============ List of All Electronic Product===========");
			prod.listOfALLElectronicProduct().forEach(System.out::println);
			break;
	     
		case "6":
			System.out.println("=================== Add New Category=================");
			e1.addCategory();
			break;
		case "7":
			System.out.println("==================== Add New Brand ==================");
			e1.addNewBrand();
			break;
		case "8":
			System.out.println("=================== Add New Product==================");
			e1.addNewProduct();
			break;
			
		case "9":
			System.out.println("================ List of ALL Orders ==================");
			e1.allOrderPrdouct();
			break;
			
		case "10":
			System.out.println("================== Clear all cart Items ===============");
			e1.clearAllCartUtility();
			break;
				
	}
}
}
