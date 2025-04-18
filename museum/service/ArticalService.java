package com.museum.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

import com.museum.dao.ArticalDao;
import com.museum.entity.Artical;
import com.museum.entity.Category;
import com.museum.exception.ResourceAlreadyExistException;
import com.museum.exception.ResourseNotFountException;

public class ArticalService {
	private ArticalDao articalDao;
	
public ArticalService() throws SQLException{
	
	articalDao = new ArticalDao();
}
public void addArticale(String name,Category category, LocalDate createdDate ,String createorName)throws SQLException, ResourceAlreadyExistException {
Optional<Artical>existingArtical=articalDao.findAll().stream()
.filter(article->article.getName().equalsIgnoreCase(name)).findFirst();
if(existingArtical.isEmpty())
{
	Artical newArtical= new Artical(null,name,category,createdDate,createorName);
	boolean status = articalDao .save( newArtical);
	if(status) {
		System.out.println("Artical added successfully!");
	}else {
		System.out.println("Artical failed to add !");
	}
	
	
}else {
	throw new ResourceAlreadyExistException("Artical already exist with the same name: "+name);
}
}
public void displayAllArtical()throws SQLException {
	articalDao.findAll().stream().forEach(artical->System.out.println(artical));
}
public void displayAllArticalDtails(Integer id)throws SQLException {
	Artical foundArtical= articalDao.findById(id);
	if(foundArtical!=null) {
		System.out.println("Artical found");
	}
	else {
		throw new ResourseNotFountException("Not Found");
	}	
}
public void updateArticle(int id, String name, Category category, LocalDate createdDate, String creatorName) throws SQLException,ResourseNotFountException {
	Artical art = articalDao.findById(id);
	if (art != null) {
	Boolean status = articalDao.update(new Artical(id, name, category, createdDate, creatorName));
	if (status)
		System.out.println("Article deleted Sucessfully!!");
	else
		System.out.println("Article failed to delete!!");
	}
	else
		throw new ResourseNotFountException("Article not found with id " + id);

	
}

public void deleteArticle(int id) throws SQLException {
	Boolean status = articalDao.delete(id);
	if (status)
		System.out.println("Article deleted Sucessfully!!");
	else
		System.out.println("Article failed to delete!!");
	
}


}