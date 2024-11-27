package testing;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import dao.StudentRegistrationDao;
import model.Semester;
import model.Student;

public class QuestionOne {

	
	@Test
	public void testFetchStudentsBySemester() {

	    StudentRegistrationDao registrationStudDao = new StudentRegistrationDao();
	    Semester theSemester = new Semester();
	    theSemester.setSemId("SemSeptember");

	    List<Student> etudiants = registrationStudDao.fetchStudentsBySemester(theSemester);

	    
	    assertNotNull(etudiants);
	    
	}


}
