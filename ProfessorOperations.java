package Operations;
import java.sql.*;
import java.util.ArrayList;
import entity.Professor;

public class ProfessorOperations {

		public static void insertProfessor(Connection con,Professor professor) {
				
				String sqlQuery="INSERT INTO professor values(?,?)";
				try {
					PreparedStatement ps = con.prepareStatement(sqlQuery);
					ps.setInt(1, professor.getProfessorId());
					ps.setString(2,professor.getProfessorName());
					ps.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		public static void deleteCourse(Connection con, int professorId) {
			
			String sqlQuery="DELETE from professor where professorId =?";
			try {
				PreparedStatement ps = con.prepareStatement(sqlQuery);
				ps.setInt(1, professorId);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public static void updateCourse(Connection con,String uprofessorName , int professorId) {
		    String sqlQuery="update professor set professorName=? where professorId=?";
		    try {
		        PreparedStatement ps = con.prepareStatement(sqlQuery);
		        ps.setString(1, uprofessorName);
		        ps.setInt(2, professorId);
		        ps.executeUpdate();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
		
		public static ArrayList<Professor> displayCourse(Connection con){
			ArrayList<Professor> professor = new ArrayList<Professor>();  //employees : all the records of emp4 table is stored
			Statement stmt;
			try {
				stmt = con.createStatement();
				ResultSet rs=stmt.executeQuery("select * from professor");  
				while(rs.next())
				{   
					int professorId = rs.getInt("professorId");  
					String professorName = rs.getString(" professorName");
					Professor professoro = new Professor(professorName,professorId); //calling student constructor
					professor.add(professoro);
					
					
				}
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}  
			for(int i=0; i< professor.size(); i++) {  //printing the rec
				System.out.println(professor.get(i));
			}
			return professor;
		}
}
