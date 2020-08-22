package entity;

public class Professor {
	private String professorName;
	private  int	 professorId;
	public Professor(String professorName, int professorId) {
		super();
		this.professorName = professorName;
		this.professorId = professorId;
	}
	public String getProfessorName() {
		return professorName;
	}
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	public int getProfessorId() {
		return professorId;
	}
	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}
	@Override
	public String toString() {
		return "Professor [professorName=" + professorName + ", professorId=" + professorId + "]";
	}
	
	
}
