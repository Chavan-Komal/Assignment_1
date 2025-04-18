package com.museum;

import java.time.LocalDate;
import java.util.Scanner;

import com.museum.entity.Category;
import com.museum.service.ArticalService;

public class Artical_Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		ArticalService service=null;
		try {
			 service= new ArticalService();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	boolean exit = true;
	while(exit)
	{
		System.out.println("++++++++Menu+++++++++"
				+ "\n1.Add Artical."
				+ "\n2.Display All Artical."
				+ "\n3.Display Details of Artical."
				+ "\n4.Update Articals."
				+ "\n5.Delete Artical."
				+ "\n0.Exit");
		System.out.println("Enter your choice");
		int ch = sc.nextInt();
		switch(ch)
		{
		case 1:{
			try {
				System.out.println("Enter artical name,Category(PAINTING,SCULTURE,ARTIFACT),created date, cerator name");
				String name=sc.next();
				Category category=Category.valueOf(sc.next());
				LocalDate date= LocalDate.parse(sc.next());
				String creatorName=sc.next();
				service.addArticale(name, category, date,creatorName);
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			break;
		}
		case 2:{
			try {
				service.displayAllArtical();
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			break;
		}
		case 3:{
			try {
				System.out.println("Enter Artical id:");
				service.displayAllArticalDtails(sc.nextInt());
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			break;
		}
		case 4: {
			System.out.println("enter id");
			try {
				service.deleteArticle(sc.nextInt());
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			break;
		}
		case 5: {
			System.out.println("enter id, name, category(PAINTING,SCULPTURE, ARTIFACT),date, creator name");
			try {
				service.updateArticle(sc.nextInt(), sc.next(), Category.valueOf(sc.next()), LocalDate.parse(sc.next()), sc.next());
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}

		case 0:{
			System.exit(0);
			System.out.println("Thank you");
			break;
		}
		default:
			System.out.println("Invalid Option");
		
		}
	}

	}

}
