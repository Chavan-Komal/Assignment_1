package Practice.jdbc;

import java.util.Collection;
import java.util.Scanner;

public class Student_Main {
	
	private static void showAllStudent() {
		StudentInterfaceDao<Sudent,Integer> dao= new StudentDao();
		 Collection<Sudent> StudentList=dao.getAll();
		 StudentList.stream().forEach(stud->System.out.println(stud));
		 
	}
	private static void showOneStudent() {
		StudentInterfaceDao<Sudent,Integer> dao= new StudentDao();
		 Sudent stud =dao.getOne(1);
		 if(stud !=null) {
			 System.out.println(stud);
		 }else {
			 System.out.println("Student not found with this roll Number");
		 }
	}
	
	private static void addStudent(Sudent stud) {
		StudentInterfaceDao<Sudent,Integer> dao= new StudentDao();
		
		dao.add(stud);
		
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		StudentInterfaceDao<Sudent,Integer> dao= new StudentDao();
		while(true) {
			System.out.println("===========Menu==========="
					+ "\n1.Show One Student."
					+ "\n2.Show All Student."
					+ "\n3. Add Student."
					+ "\n4.Update Student."
					+ "\n5.Delete Student."
					+ "\n0.Exit.");
			int ch=sc.nextInt();
			switch(ch) {
			case 1:
				System.out.println("--------One Student--------");
				System.out.println("Enter Student RollNo");
				int roll=sc.nextInt();
				showOneStudent() ;
				break;
			
			case 2:
				System.out.println("--------All Students---------");
				showAllStudent();
				break;
				
			case 3:
				System.out.println("-------Add Student-----------");
				System.out.println("Enter Student rollNumber,Name,City");
				Sudent stud= new Sudent(sc.nextInt(),sc.next(),sc.next());
				addStudent( stud);
				
				break;
			case 4:
				break;
			case 5:
				
			case 0:
				System.exit(0);
				break;
				default:
					System.out.println("Invalid Choice!");
			
			
				
			
			}
		}
		
		
		
	}

}
