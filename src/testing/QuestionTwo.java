package testing;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import model.AcademicUnit;
import model.Semester;
import model.Student;

import dao.StudentRegistrationDao;

public class QuestionTwo {

	
	@Test
	public void testFetchStudentsByDepartmentAndSemester() {
	    // Arrange
		StudentRegistrationDao registrationStudDao = new StudentRegistrationDao();
	    AcademicUnit department = new AcademicUnit(); 
	    department.setCode("4"); 
	    Semester theSemester = new Semester();
	    theSemester.setSemId("SemSeptembre");
	    

	    
	    List<Student> etudiants = registrationStudDao.fetchStudentsByDepartmentAndSemester(department, theSemester);

	    
	    assertNotNull(etudiants);
	    
	}


}
