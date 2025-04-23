package com.Airline.Service;

import java.time.LocalDate;
import java.util.List;

import com.Airline.Dao.FightDao;
import com.Airline.entity.Flight;

public class FlightService {
private FightDao flightDao;

public FlightService() {
	flightDao = new FightDao();
}

 public List< Flight> serchFlight(String source,String destination,LocalDate date){

	 return flightDao.serchFlight(source, destination, date);
	 
 }
}
