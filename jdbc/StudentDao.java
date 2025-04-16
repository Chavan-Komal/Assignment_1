package Practice.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import example.jdbc.Department;
import example.jdbc.JdbcUtils;

public class StudentDao implements  StudentInterfaceDao <Sudent  ,Integer>{

	
	private Object rollNo;
	private int rollno;
	private Department stud;

	@Override
	public Collection<Sudent> getAll() {
		
		Collection<Sudent> allStudents= new ArrayList<>();
		
		try {
			Connection dbConnection= JdbcStudUtils.buildConnection();
			Statement st= dbConnection.createStatement(); 
			ResultSet rs= st.executeQuery("select * from stud");
			while(rs.next()) {
				int RollNo=rs.getInt(1);
				String name=rs.getNString(2);
				String City= rs.getString(3);
				Sudent stud= new Sudent(RollNo,name,City);
				allStudents.add(stud);
				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return allStudents;
	}

	@Override
	public Sudent getOne(Integer rollNo) {
		Sudent foundrollNo=null;
		String sqlQuery="select * from stud where rollno = ?";
		try(
				Connection dbConnection= JdbcStudUtils.buildConnection();
			PreparedStatement stmt = dbConnection.prepareStatement(sqlQuery)){ 
			
		   stmt.setInt(1, rollNo);
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
			{
				int rollno=rs.getInt(1);
				String name=rs.getNString(2);
				String city= rs.getString(3);
				foundrollNo = new Sudent(rollno,name,city);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	
		return foundrollNo;
	}

	@Override
	public void add(Sudent t) {
		String sqlQuery="insert into dept values(?,?,?)";
		try(
          Connection dbConnection = JdbcUtils.buildConnection();
		  PreparedStatement pstmt =  dbConnection.prepareStatement(sqlQuery);
				){
			int rollNo=t.getRollno();
			String name=t.getName();
			String city= t.getCity();
			pstmt.setInt(1, rollNo);
			pstmt.setString(2, name);
			pstmt.setString(3, city);
			int updateCount = pstmt.executeUpdate();
			System.out.println(updateCount+" record inserted");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void Update(Sudent t) {
		
		
		
	}

	@Override
	public void Delete(Integer rollNo) {
		// TODO Auto-generated method stub
		
	}

}
