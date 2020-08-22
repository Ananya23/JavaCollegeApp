package Operations;
import entity.Student;
import java.sql.*;
import java.util.*;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException {
		
		Scanner sc= new Scanner(System.in);
		Connection conn = null;
		try{
			
		        Class.forName("oracle.jdbc.driver.OracleDriver");//to load the driver in the memory
		      	conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","hr","hr");
				System.out.println("Connection is successful !!!!!!!!!!!!!");
				
				Student obj = new Student();
				
				System.out.println("Enter the student name");
				String sname= sc.next();
				obj.setStudentName(sname);
				System.out.println("Enter the student id");
				int  sId= sc.nextInt();
				obj.setStudentId(sId);
				sc.close();
				
				StudentOperations.insertStudent( conn, obj);
				
				StudentOperations.displayStudent(conn);
								
		}
		
			catch(SQLException e )	
			{
				System.out.println(e.getMessage());
			}
	}

}
