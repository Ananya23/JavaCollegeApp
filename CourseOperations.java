package Operations;
import java.sql.*;
import java.util.ArrayList;
import entity.Course;


public class CourseOperations {
public static void insertCourse(Connection con, Course course) {
		
		String sqlQuery="INSERT INTO course values(?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, course.getCourseId());
			ps.setString(2,course.getCourseName());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
public static void deleteCourse(Connection con, int courseId) {
	
	String sqlQuery="DELETE from course where courseId =?";
	try {
		PreparedStatement ps = con.prepareStatement(sqlQuery);
		ps.setInt(1, courseId);
		ps.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public static void updateCourse(Connection con,String ucourseName , int courseId) {
    String sqlQuery="update course set courseName=? where courseId=?";
    try {
        PreparedStatement ps = con.prepareStatement(sqlQuery);
        ps.setString(1, ucourseName);
        ps.setInt(2, courseId);
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    public static ArrayList<Course> displayCourse(Connection con){
	ArrayList<Course> course = new ArrayList<Course>();  //employees : all the records of emp4 table is stored
	Statement stmt;
	try {
		stmt = con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from course");  
		while(rs.next())
		{   
			int courseId = rs.getInt("courseId");  
			String courseName = rs.getString("courseName");
			Course courseo = new Course(courseId,courseName); //calling student constructor
			course.add(courseo);
			
			
		}
	} 
	catch (SQLException e) {
		e.printStackTrace();
	}  
	for(int i=0; i< course.size(); i++) {  //printing the rec
		System.out.println(course.get(i));
	}
	return course;
}
		


	
}
