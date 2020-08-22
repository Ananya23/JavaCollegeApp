package Operations;
import java.sql.*;
import java.util.ArrayList;


import entity.Student;


public class StudentOperations {
	
	    public static void insertStudent(Connection con, Student student) {
		
		String sqlQuery="INSERT INTO student values(?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, student.getStudentId());
			ps.setString(2,student.getStudentName());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
        public static void deleteStudent(Connection con, int studentId) {
		
		String sqlQuery="DELETE from student where studentId =?";
		try {
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, studentId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    public static void updateStudent(Connection con,String updstudentName , int studentId) {
    String sqlQuery="update student set studentName=? where studentId=?";
    try {
        PreparedStatement ps = con.prepareStatement(sqlQuery);
        ps.setString(1, updstudentName);
        ps.setInt(2, studentId);
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    public static ArrayList<Student> displayStudent(Connection con){
    	ArrayList<Student> student = new ArrayList<Student>();  //employees : all the records of emp4 table is stored
    	Statement stmt;
    	try {
    		stmt = con.createStatement();
    		ResultSet rs=stmt.executeQuery("select * from student");  
    		while(rs.next())
    		{   
    			int studentId = rs.getInt("studentId");  
    			String studentName = rs.getString("studentName");
    			Student studento = new Student(studentId,studentName); //calling student constructor
    			student.add(studento);
    			
    			
    		}
    	} 
    	catch (SQLException e) {
    		e.printStackTrace();
    	}  
    	for(int i=0; i< student.size(); i++) {  //printing the rec
			System.out.println(student.get(i));
		}
    			return student;
	
    }
}
