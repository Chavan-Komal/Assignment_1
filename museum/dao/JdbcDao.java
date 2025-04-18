package com.museum.dao;

import java.sql.SQLException;
import java.util.Collection;

public interface JdbcDao <T,K>{
	Boolean save(T t)throws SQLException;
	Collection<T> findAll()throws SQLException ;
	T findById(K key)throws SQLException;
	
	Boolean update(T t)throws SQLException;
	Boolean delete(K key)throws SQLException;

}
