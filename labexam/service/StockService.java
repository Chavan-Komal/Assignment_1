package com.rest.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import com.rest.dao.StockRepository;

import com.rest.entity.Stock;
import com.rest.exception.ResourceAlreadyExistException;
import com.rest.exception.ResourceNoptFoundException;



@Service
public class StockService {
	
	@Autowired
	private StockRepository stockRepo;
	
      public Stock CreateStock(Stock newStock) 
    {
    	  Stock isStock= stockRepo.findByName(newStock.getCompanyName());
    	  if(ObjectUtils.isEmpty(isStock)) {
    		  
    		  throw new ResourceAlreadyExistException("Stock is Available Exist");
    		  
    	  }else {
    		  return  stockRepo.save(newStock);
    	  }
   
	
    }
	
	
	public List<Stock> readStock(){
		
		return stockRepo.findAll();
	}
	
	
	public Stock getOneStock(Integer id) {
		 
		return stockRepo.findById(id)
				.orElseThrow(()-> new  ResourceNoptFoundException ("Stock not found of id:" + id));
		
	 }
	
	public Stock getStockByName(String name) 
	{
	    Stock foundStock = stockRepo.findByName(name);
		if(ObjectUtils.isEmpty( foundStock))
		{
			throw new ResourceNoptFoundException("Stock not found of Name: " + name);
		}
		else
		{
			return foundStock;
		}
		
	}
	
	 public void IncreseStock(Stock newStock) {
		 
	 }
	 
	 
	 
	 public String DeleteStock(Integer id) {
		 //Stock existingStock=stockRepo.findByName(name.getCompanyName());;
		 
		 Stock foundStock =
					stockRepo.findById(id).orElseThrow(() ->
					 new ResourceNoptFoundException("Stock not found of id : "+id));
		
			
		 stockRepo.delete(foundStock);
		 return "Stock deleted succussfully";
	 }
	

	
	
	
	
}
