package com.Airline.Service;

import java.util.List;

import com.Airline.Dao.BookingDao;
import com.Airline.Exception.ResourceNotFoundException;
import com.Airline.entity.Booking;

public class BookingService {
	
	private BookingDao bookingDao;
	public BookingService() {
		bookingDao = new BookingDao();
		
	}
	
	public boolean bookFlight(int userId , int flightId) {
		return bookingDao.save(userId, flightId);
		
	}
	
	public List<Booking>getBokkingByUserId(int userId){
		return bookingDao.findById(userId) ;
		
	}
	public boolean cancelFlight(int bId)
	{
		return bookingDao.cancelFlight(bId);
	}

}
