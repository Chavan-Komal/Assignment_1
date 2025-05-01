package com.rest.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.rest.entity.Stock;
import com.rest.service.StockService;

@RestController  
@RequestMapping("/stocks")
public class StockController {
	
	@Autowired
	public StockService stockServiceRef;
	
	//http://localhost:8084/stocks/add
	@PostMapping("/add")
	  public String CreateStock(@RequestBody Stock newStock) 
	    {
		  try {
			  stockServiceRef.CreateStock(newStock);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		  return "Stock Created Successfully!";
	    }
	
	//http://localhost:8084/stocks/all
	@GetMapping("/all")
	public ResponseEntity<?> readStocks() {	
		List<Stock> stocks = stockServiceRef.readStock();
		if(CollectionUtils.isEmpty(stocks))
		{
			return new ResponseEntity<>("Stock not available", HttpStatus.NO_CONTENT);
		}
		else
		{
			return new ResponseEntity<>(stocks, HttpStatus.OK);
		}
			
	}
	
	//http://localhost:8084/stocks/all
	@GetMapping("/{id}")	
    public String getOneStock(@PathVariable Integer id) {
	
    	try {
    		stockServiceRef.getOneStock(id);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	
    	return "get Stock succesfully!";
  }
    
	
	    //http://localhost:8084/stocks/name/{name}
	@GetMapping("/name/{name}")
	public ResponseEntity<?> getStockByName(@PathVariable String name)
	{
		try
		{
			Stock foundTeam = stockServiceRef.getStockByName(name);
			return new ResponseEntity<>(foundTeam, HttpStatus.OK);
		}
		catch(Exception ex)
		{
			
			return new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
        
        

}
