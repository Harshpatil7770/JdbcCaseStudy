package com.ecart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ecart.config.DBconfig;
import com.ecart.model.Brand;
import com.ecart.model.Category;
import com.ecart.model.Product;

public class ProductDaoImpl {

	public List<Product> fetchAllProducts(){
		List<Product> list=new ArrayList<Product>();
		try {
			Connection conn=DBconfig.getConnection();
			Statement st=conn.createStatement();
			String queury="select * from products p inner join brands b on p.brand_id=b.brand_id inner join categories c on p.category_id=c.category_id";
			ResultSet rs=st.executeQuery(queury);
			while(rs.next()) {
				Product product=new Product();
				Brand brand=new Brand();
				Category category=new Category();
				product.setProductId(rs.getInt("product_id"));
				product.setProductTitle(rs.getString("product_title"));
				product.setProductPrice(rs.getDouble("product_price"));
				product.setDescription(rs.getString("product_description"));
				
				brand.setBrandId(rs.getInt("brand_id"));
				brand.setBrandTitle(rs.getString("brand_title"));
				
				category.setCategoryId(rs.getInt("category_id"));
				category.setCategoryTitle(rs.getString("category_title"));
				
				product.setBrand(brand);
				product.setCategory(category);
				
				list.add(product);
			}
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		DBconfig.closeConnection();
	}
		return list;
}
	
	public List<Brand> listOfAllBrand(){
		List<Brand> list=new ArrayList<Brand>();
		try {
			Connection conn=DBconfig.getConnection();
			Statement st=conn.createStatement();
			String query="select * from brands";
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				Brand brand=new Brand();
				
				brand.setBrandId(rs.getInt("brand_id"));
				brand.setBrandTitle(rs.getString("brand_title"));
				
				list.add(brand);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBconfig.closeConnection();
		}
		return list;
	}
	
	public List<Category> listOfAllCategories(){
		 List<Category> list=new  ArrayList<Category>();
		 try {
			 Connection conn=DBconfig.getConnection();
			 Statement st=conn.createStatement();
			 String query="select * from categories";
			 ResultSet rs=st.executeQuery(query);
			 while(rs.next()) {
				 Category category=new Category();
				 category.setCategoryId(rs.getInt("category_id"));
				 category.setCategoryTitle(rs.getString("category_title"));
				 
				 list.add(category);
			 }
		 }catch(Exception e) {
			 e.printStackTrace();
		 }finally {
			 DBconfig.closeConnection();
		 }
		 return list;
	}
	
	public List<Product> listOfALLProductHavingNameSamsung(){
		List<Product> list=new ArrayList<Product>();
		try {
			 Connection conn=DBconfig.getConnection();
			 Statement st=conn.createStatement();
			 String query="select * from products p inner join brands b on p.brand_id=b.brand_id where brand_title='Samsung'";
				ResultSet rs=st.executeQuery(query);
				while(rs.next()) {
					Product product=new Product();
					Brand brand=new Brand();
			
					product.setProductId(rs.getInt("product_id"));
					product.setProductTitle(rs.getString("product_title"));
					product.setProductPrice(rs.getDouble("product_price"));
					product.setDescription(rs.getString("product_description"));
					
					brand.setBrandId(rs.getInt("brand_id"));
					brand.setBrandTitle(rs.getString("brand_title"));
					
					product.setBrand(brand);
					
					list.add(product);
		}
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		DBconfig.closeConnection();
	}
		return list;
}
	
	public List<Product> listOfALLElectronicProduct(){
		List<Product> list=new ArrayList<Product>();
		try {
			 Connection conn=DBconfig.getConnection();
			 Statement st=conn.createStatement();
			 String query="select * from products p inner join categories c on p.category_id=c.category_id where  category_title='ELectronic Product'";
				ResultSet rs=st.executeQuery(query);
				while(rs.next()) {
					Product product=new Product();
					 Category category=new Category();
					 category.setCategoryId(rs.getInt("category_id"));
					 category.setCategoryTitle(rs.getString("category_title"));
			
					product.setProductId(rs.getInt("product_id"));
					product.setProductTitle(rs.getString("product_title"));
					product.setProductPrice(rs.getDouble("product_price"));
					product.setDescription(rs.getString("product_description"));
					
					product.setCategory(category);

					
					list.add(product);
		}
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		DBconfig.closeConnection();
	}
		return list;
	}
	
	public void addNewCategory(Category category) {
		try {
			 Connection conn=DBconfig.getConnection();
			 String query="insert into categories values(?,?)";
			 PreparedStatement st=conn.prepareStatement(query);
			st.setInt(1,category.getCategoryId());
			st.setString(2,category.getCategoryTitle());
			
			int res=st.executeUpdate();
			if(res!=0) {
				System.out.println("New Category Added Succesfully  CATEGORYID:: "+category.getCategoryId()+" CATEGORYNAME "+category.getCategoryTitle());
				
			}else {
				System.out.println("============== Record not saved ====================");
			}
				 
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBconfig.closeConnection();
		}
		
	}
	
	public void addNewBrand(Brand brand) {
		try {
			Connection conn=DBconfig.getConnection();
			String query="insert into brands values(?,?)";
			PreparedStatement p1=conn.prepareStatement(query);
			p1.setInt(1,brand.getBrandId());
			p1.setString(2,brand.getBrandTitle());
			
			int res=p1.executeUpdate();
			if(res!=0) {
				System.out.println(" New Brand Add Succesfully BRANDID ::"+ brand.getBrandId()+" BRANDNAME ::"+brand.getBrandTitle());
			}else {
				System.out.println("======== Record not Saved ==========");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBconfig.closeConnection();
		}
	}
	
	public void addNewProduct(Product product) {
		try {
			Connection conn=DBconfig.getConnection();
			String query="insert into products values(?,?,?,?,?,?)";
			PreparedStatement p1=conn.prepareStatement(query);
			 p1.setInt(1,product.getProductId());
			 p1.setString(2,product.getProductTitle());
			 p1.setDouble(3,product.getProductPrice());
			 p1.setString(4,product.getDescription());
			 p1.setInt(5,product.getBrand().getBrandId());
			 p1.setInt(6,product.getCategory().getCategoryId());
			 
			 int res=p1.executeUpdate();
			 if(res!=0) {
				 System.out.println(" New Product Added Succesfully ");
			 }else {
				 
				 System.out.println(" Records Not saved");
			 }
			 
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBconfig.closeConnection();
		}
	}
	
	public List<Product> allOrderOfUser(Product product) {
		List<Product> list=new ArrayList<Product>();
		try {
			Connection conn=DBconfig.getConnection();
			Statement s1=conn.createStatement();
			String q1="select product_title,product_price from products p inner join orders o on p.product_id=o.product_id and inner join user_info u on u.user_id=o.user_id where u.first_name='"+product.getFirstName()+"'";
			
			ResultSet rs=s1.executeQuery(q1);
			while(rs.next()) {
				Product product1=new Product();
				product1.setProductTitle(rs.getString("product_title"));
				product1.setProductPrice(rs.getDouble("product_double"));
				list.add(product1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBconfig.closeConnection();
		}
		return list;
	}
	
	public void clearAllCart(String userId) {
		try {
			Connection conn=DBconfig.getConnection();
			String q1="delete from cart where user_id=?";
			PreparedStatement s1=conn.prepareStatement(q1);
			s1.setString(1, userId);
			int res=s1.executeUpdate();
			if(res!=0) {
				System.out.println("clear all items in cart"+userId);
			}else {
				System.out.println("Items not found");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBconfig.closeConnection();
		}
	}
	

}
