package entity;

public class Student {
	private int  studentId;
	private String studentName;
	//public Student(int studentId, String studentName) {
		//super();
		//this.studentId = studentId;
		//this.studentName = studentName;
	//}
	public Student(int studentId, String studentName) {
		this.studentId = studentId;
		this.studentName = studentName;
	}
	
	public Student() {
		this.studentId = 0;
		this.studentName = "";
	}	
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	@Override
	public String toString() {
		return "studentId=" + studentId + ", studentName=" + studentName ;
	}
	
}
