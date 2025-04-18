package com.museum.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import com.museum.entity.Artical;
import com.museum.entity.Category;
import com.museum.utils.JdbcUtils;

public class ArticalDao implements JdbcDao <Artical,Integer>{

	private Connection con;
	private String query;
	private PreparedStatement pstm;
	private Statement stmt;
	private Collection<Artical> articals;
	
	public  ArticalDao()throws SQLException {
		con= JdbcUtils.getdbConnection();
		
	}
	
	@Override
	public Boolean save(Artical artical)throws SQLException {
	 query = "insert into article values(?,?,?,?,?);";
	 pstm=con.prepareStatement(query);
	 pstm.setInt(1, 0);
	 pstm.setString(2, artical.getName());
	 pstm.setString(3, artical.getCategory().toString());
	 pstm.setDate(4,Date.valueOf(artical.getCreateDate()));
	 pstm.setString(5, artical.getCreatorName());
	 int count= pstm.executeUpdate();
	 if(count > 0)
	 {
		 System.out.println(count+"row iserted");
		 return true;
	 }
	 else {
		 return false; 
	 }
	
	}

	@Override
	public Collection<Artical> findAll() throws SQLException {
		List<Artical>articals =new ArrayList<Artical>();
		 query = "select * from article;";
		 stmt=con.createStatement();
		 ResultSet rs=stmt.executeQuery(query);
		 while(rs.next()) {
			 int id=rs.getInt("id");
			 String name= rs.getString("name");
			Category category= Category.valueOf(rs.getString("category"));
			LocalDate date= rs.getDate("date_created").toLocalDate();
			String creatorName=rs.getString("creator_name");
			 Artical artical=new Artical(id,name,category,date,creatorName);
			articals.add(artical);
		 }
		return articals;
	}

	@Override
	public Artical findById(Integer key) throws SQLException {
		Artical foundarticale= null;
		query="select * from article where id=?";
		pstm=con.prepareStatement(query);
		pstm.setInt(1, key);
		ResultSet rs=pstm.executeQuery();
		while(rs.next())
		{
			int id=rs.getInt("id");
			 String name= rs.getString("name");
			Category category= Category.valueOf(rs.getString("category"));
			LocalDate date= rs.getDate("date_created").toLocalDate();
			String creatorName=rs.getString("creator_name");
			 Artical artical=new Artical(id,name,category,date,creatorName);
			 foundarticale=artical;
		}
		return foundarticale;
	}


	@Override
	public Boolean update(Artical article) throws SQLException {
		query = "update article set name = ?, category = ?,date_created  = ?,creator_name = ? where  id  = ?";
		pstm = con.prepareStatement(query);
		pstm.setString(1, article.getName());
		pstm.setString(2, article.getCategory().toString());
		pstm.setDate(3, Date.valueOf(article.getCreateDate()));
		pstm.setString(4, article.getCreatorName());
		pstm.setInt(5, article.getId());
		int count = pstm.executeUpdate();

		if (count > 0) {
			System.out.println(count + " rows affected!");
			return true;
		}
		return false;

		
	}


	@Override
	public Boolean delete(Integer id) throws SQLException {
		query = "delete from article where id = ?";
		pstm = con.prepareStatement(query);
		pstm.setInt(1, id);
		int count = pstm.executeUpdate();

		if (count > 0) {
			System.out.println(count + " rows affected!");
			return true;
		}
		return false;
	}

		
}


	


