package com.Airline.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Airline.Utils.JdbcUtils;
import com.Airline.entity.Booking;

public class BookingDao {
	private String query;
	public boolean save(int userId,int flightId) {
		boolean status = false;
		query="insert into booking(user_id ,flight_id) values(?,?)";
		try (
				Connection con =JdbcUtils.getdbConnection();
				PreparedStatement pstm =con.prepareStatement(query);
				){
			
			pstm.setInt(1, userId);
			pstm.setInt(2, flightId);
			int count=pstm.executeUpdate();
			
			if(count > 0) {
				System.out.println(count+" Row inserted!");
				status=true;
				
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return status;
	}

	public List<Booking> findById(int userId){
		List<Booking>bookings = new ArrayList<Booking>();
		query="select * from booking where user_id =?";
		try (
				Connection con =JdbcUtils.getdbConnection();
				PreparedStatement pstm =con.prepareStatement(query);
				){
			pstm.setInt(1, userId);
			ResultSet rs=pstm.executeQuery();
			while(rs.next()) {
				bookings.add (new Booking(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getDate(4).toLocalDate()));
			}
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return bookings;
	}

	public boolean cancelFlight(int id) {
		boolean status = false;
		
		query="delete from flight where id= ?";
		try (
				Connection con =JdbcUtils.getdbConnection();
				PreparedStatement pstm =con.prepareStatement(query);
				){
			pstm.setInt(1, id);
			int count=pstm.executeUpdate();
			if(count > 0) {
				System.out.println(count+" Row Deleted!");
				status=true;
				
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		
		return status;
	}

	
}
